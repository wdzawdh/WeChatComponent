package com.cw.application.api

import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 *
 * 微信去api化方案
 *
 * 运行buildApi任务，将所有".api"结尾的文件拷贝到指定module，并将文件名修改为".java"
 *
 */
class GradleApiPlugin implements Plugin<Project> {

    private static final String API_MODULE_KEY = "apiModule"
    private static final String GROUP_ID = "cw"
    private static final String TASK_NAME = "buildApi"

    private boolean isAutoRun = false //是否自动执行

    @Override
    void apply(Project project) {
        checkEnv(project)
        if (isAutoRun) {
            project.afterEvaluate {
                def moduleName = getModuleName(project)
                deleteApiModule(project, moduleName)
                copyApiModule(project, moduleName)
            }
        } else {
            project.tasks.create(name: TASK_NAME) {
                setGroup(GROUP_ID)
                setDescription("buildApi一键执行")
            }.doFirst {
                def moduleName = getModuleName(project)
                deleteApiModule(project, moduleName)
                copyApiModule(project, moduleName)
            }
        }
    }

    /**
     * 初始化必要状态
     * @param project
     * @param configName
     */
    private static void checkEnv(Project project) {
        if (!project.rootProject.hasProperty(API_MODULE_KEY)) {
            throw new GradleException("please set " + API_MODULE_KEY + " in the root properties")
        }
    }

    /**
     * 删除ApiModule文件
     * @param project
     * @param moduleName
     */
    private static void deleteApiModule(Project project, String moduleName) {
        String filePath = getModuleJavaPath(project, moduleName)
        project.delete filePath
        println "delete ${API_MODULE_KEY}"
    }

    /**
     * 拷贝至ApiModule,将".api"改名为".java"
     * @param project
     * @param moduleName
     */
    private static void copyApiModule(Project project, String moduleName) {
        println "copyto ${API_MODULE_KEY}"
        project.copy {
            setIncludeEmptyDirs(false)
            for (Project pro : project.rootProject.getAllprojects()) {
                String currentProjectPath = getProjectJavaPath(pro)
                from(currentProjectPath) {
                    include '**/**.api'
                }
            }
            String apiModulePath = getModuleJavaPath(project, moduleName)
            into(apiModulePath)
            rename { String filename ->
                int index = filename.indexOf(".api")
                String name = filename[0..index] + "java"
                return name
            }
        }
    }

    /**
     * 获取ModuleName
     * @param project
     * @return
     */
    private static String getModuleName(Project project) {
        return project.rootProject.properties.get(API_MODULE_KEY)
    }

    /**
     * 获得当前项目java目录
     * @param project
     * @return
     */
    private static String getProjectJavaPath(Project project) {
        return project.projectDir.path + "/src/main/java"
    }

    /**
     * 获得指定项目java目录
     * @param project
     * @param moduleName
     */
    private static String getModuleJavaPath(Project project, String moduleName) {
        return project.rootProject.project(moduleName).projectDir.path + "/src/main/java"
    }
}