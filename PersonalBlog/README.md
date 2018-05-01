项目重构后的业务流程
主要分为businesswork业务层，framework辅助层，dao数据访问层

Controller 主要前端控制器 每个方法都是一个接口  
主要分为三部分：用户中心PbUserController;博客中心PbBlogController;购物中心PbMallController  
ViewRegistration  View页面的注册中心  
AppContext 手动获取bean  
result 用来承接service返回的结果集  
  
framework层主要提供非业务方法，提供拦截器，过滤器等