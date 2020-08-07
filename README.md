# WeChatComponent
微信模块化 .api化与pins工程结构

### 参考文章
> https://mp.weixin.qq.com/s/mkhCzeoLdev5TyO6DqHEdw <br>
https://tech.meituan.com/2018/03/16/meituan-food-delivery-android-architecture-evolution.html

### 模块结构
```  
模块分隔
         ╱:module_main(模块一)╲
:app(壳) ——:module_chat(模块二)—— :lib_common(基类，账号、网络、存储等业务) —— :lib_foundation(SDK)
         ╲:module_mine(模块三)╱

模块内pins细分
:module_chat —— main、p_conversation、p_group
:module_mine —— mian、p_pay、p_setting
```

### gradle任务
用于将.api文件移动至:api模块下，每次修改.api后都需要运行。<br>
也可以配置为自动运行，使用GradleApiPlugin的isAutoRun变量控制。
```
./gradlew buildApi
```

### 配置多模块 build.gradle(:app)
```
dependencies {

    //可以将不需要编译的模块注释（由于入口在:module_main，要注释:module_main需要将入口移到别的模块才能正常启动）
    implementation project(path: ':module_main')
    implementation project(path: ':module_chat')
    implementation project(path: ':module_mine')
    
    //也可将模块打包成arr供:app使用
    /*implementation(name: 'api', ext: 'aar')
    implementation(name: 'module_main', ext: 'aar')
    implementation(name: 'module_chat', ext: 'aar')
    implementation(name: 'module_mine', ext: 'aar')
    implementation(name: 'lib_common', ext: 'aar')*/
}
```
