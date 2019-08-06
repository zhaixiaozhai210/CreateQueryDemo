# SpringBoot 扩展和封装Spring Data JPA

**为什么要扩展JPA**

在编写 Spring Data JPA 的 DAO 时， 只需在接口中按规约提供方法的声明即可。 而有些业务实现无法通过声明方法或编写简单 SQL 实现， 这就需要扩展Spring Data JPA。

## 自定义Repository实现来定制一个动态条件查询

1. 定义BaseDao接口

```java
@NoRepositoryBean
public interface BaseDao<T, ID extends Serializable>
        extends JpaRepository<T, ID>,
        JpaSpecificationExecutor<T> {

}

```

 @NoRepositoryBean指明当前这个接口不是我们领域类的接口，该接口继承了**JpaRepository**，让我们具备了JpaRepository所提供的方法；继承了**JpaSpecificationExecutor**,让我们具备使用Specification能力

2. Base接口的实现

   ```java
   public class BaseDaoImpl<T, ID extends Serializable>
           extends SimpleJpaRepository<T, ID>
           implements BaseDao<T, ID>{
   
       public BaseDaoImpl(Class<T> domainClass, EntityManager em) {
           super(domainClass, em);
       }
   
   }
   ```

  此类继承了JpaRepository的实现类**SimpleJpaRepository**,让我们可以使用SimpleJpaRepository的方法，此类当然还要实现我们自定义的接口BaseDao.

3. 定义repositoryFactoryBean:

   ```java
   
   public class BaseDaoFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable>
           extends JpaRepositoryFactoryBean<T, S, ID> {
   
       public BaseDaoFactoryBean(Class<? extends T> repositoryInterface) {
           super(repositoryInterface);
       }
   
       @Override
       protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
           return new CustomRepositoryFactory(entityManager);
       }
   
       private static class CustomRepositoryFactory extends JpaRepositoryFactory {
   
           public CustomRepositoryFactory(EntityManager entityManager) {
               super(entityManager);
           }
   
           @Override
           protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(
                   RepositoryInformation information, EntityManager entityManager) {
               return new BaseDaoImpl<T, ID>((Class<T>) information.getDomainType(), entityManager);
           }
   
           @Override
           protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
               return BaseDaoImpl.class;
           }
       }
   }
   ```

   自定义JpaRepositoryFactoryBean替代默认RepositoryFactoryBean,我们会获得一RepositoryFactory,RepositoryFactory将会注册我们自定义的Repository的实现。

4. 开启自定义支持

   ```java
   @SpringBootApplication
   @EnableJpaRepositories(repositoryFactoryBeanClass = BaseDaoFactoryBean.class)//开启自定义支持
    public class CreateQueryDemo {
        public static void main(String[] args) {
            SpringApplication.run(CreateQueryDemo.class, args);
        }
    }
   ```

   
