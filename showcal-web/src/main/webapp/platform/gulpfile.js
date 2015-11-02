var gulp = require("gulp");
var gulpLoadPlugins = require("gulp-load-plugins");
var plugins = gulpLoadPlugins();
var browserSync = require('browser-sync');
var karma = require('gulp-karma');
var del = require("del");
////////////////////////////////////////////////////////////////////////////////////////////////////////////版本
//版本


var demoName="platform";

//css
var bootstrapCssVersion="1.0.0";
var fontVersion="1.0.8";
var showcalfontVersion = "1.0.2";
var xnStyleCommonVersion="1.0.1";

//js
var jqueryVersion="1.7.2";
var angularVersion="1.0.0";
var angularUiVersion="1.0.0";
var underscoreVersion="1.0.0";
var browserVersion="1.0.0";

var xnDirectiveCommonVersion="1.0.31";
var xnFilterCommonVersion="1.0.3";
var xnServiceCommonVersion="1.0.0";
var xnServiceFoundationVersion="1.0.0";
var xnServiceMethodVersion="1.0.2";
var xnDirectiveLoadingVersion="0.0.2";

var xnDirectiveFormVersion="1.0.1";
var xnDirectiveNavigationVersion="1.0.0";
var xnDirectiveAttachmentVersion="1.0.0";
var xnDirectiveSelectVersion="1.0.26";
var xnDirectiveLocationVersion="1.0.7";

var xnJqueryUiVersion="1.0.0";
var xnUnderscoreVersion="1.0.0";
var angularSanitizeVersion="1.3.9";


//markdown
var xnMarkDownSetting = "0.0.1";
//测试版本
var angularMocksVersion="1.3.9";

//路径
var fontFiles=[
    "spm_modules/xn-icon-common/"+fontVersion+"/font/iconfont.eot",
    "spm_modules/xn-icon-common/"+fontVersion +"/font/iconfont.ttf",
    "spm_modules/xn-icon-common/"+fontVersion+"/font/iconfont.woff",
    "spm_modules/xn-icon-showcal/" + showcalfontVersion + "/font/iconshowcalfont.eot",
    "spm_modules/xn-icon-showcal/" + showcalfontVersion + "/font/iconshowcalfont.ttf",
    "spm_modules/xn-icon-showcal/" + showcalfontVersion + "/font/iconshowcalfont.woff"
];

var buildBaseFiles=[
    "./spm_modules/jquery/"+jqueryVersion+"/jquery.js",
    "./spm_modules/xn-angular/"+angularVersion+"/angular.js",
    "./spm_modules/angular-ui/"+angularUiVersion+"/bootstraptpls.js",
    "./spm_modules/underscore/"+underscoreVersion+"/underscore.js",
    "./spm_modules/xn-browser/"+browserVersion+"/browser.js"];



//压缩本地的js文件路径 build-local-js
var buildLocalFiles=[
    "./scripts/"+demoName+".js",
    "./scripts/xn-"+demoName+"-filter.js",
    "./scripts/xn-"+demoName+"-service.js",
    "./scripts/controllers/*.js"];

gulp.task('copy-css-images', function(){
    gulp.src(copyCssImagesFiles)
        .pipe(gulp.dest("./dist/styles/images/"));
});




var mardownSettingFiles = [
    "./spm_modules/xn-markdown-setting/" +  xnMarkDownSetting + "/directive/thinker-md.js"
];


var copyCssImagesFiles=[
    "./styles/images/*"

];

var copyFontFiles=[
    "./styles/font/*",
    "./spm_modules/bootstrap-css/"+bootstrapCssVersion+"/font/*",
    "./spm_modules/xn-markdown-setting/" + xnMarkDownSetting + "/style/font/*"
];

///////////////////////////////////////////////////////////////////////////////////////////////////////版本公共的js

gulp.task("build-base-js", function() {
    gulp.src(buildBaseFiles)
        .pipe(plugins.concat("base.src.js"))
        .pipe(plugins.uglify())
        .pipe(plugins.rename("base.min.js"))
        .pipe(gulp.dest("./dist/scripts/"))
        .pipe(plugins.gzip())
        .pipe(gulp.dest("./dist/scripts/"));
});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// 图片处理
gulp.task('copy-css-images', function(){
    gulp.src(copyCssImagesFiles)
        .pipe(gulp.dest("./dist/styles/images/"));
});
// 字体添加
gulp.task('copy-font', function(){
    gulp.src(copyFontFiles)
        .pipe(gulp.dest("./dist/styles/font/"));
});
// 字体xn-icon
gulp.task('copy-xn-icon', function(){
    gulp.src(fontFiles)
        .pipe(gulp.dest("dist/styles/font/")
    );
});
//清除字font文件夹
gulp.task("clean-font", function(){
    gulp.src(["./dist/styles/font/*.ttf","./dist/styles/font/*.eot","./dist/styles/font/*.svg","./dist/styles/font/*.woff"], { read:false })
        .pipe(plugins.clean());
});

gulp.task("copy-cookies-map", function() {
    del(["./dist/scripts/angular-cookies.min.js.map", "./dist/scripts/angular-cookies.min.js.map.gz"], function(err, file) {
        console.log('Deleted files/folders:\n', file.join('\n'));
        gulp.src(["./vendor/angular-cookie/angular-cookies.min.js.map"])
            .pipe(gulp.dest("./dist/scripts"))
            .pipe(plugins.gzip())
            .pipe(gulp.dest("./dist/scripts"));
    });
});

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 合并，压缩指令，过滤器，服务等js到common.min.js
gulp.task("build-global-js", function() {
    gulp.src(buildGlobalFiles)
        .pipe(plugins.concat("global.src.js"))
        //.pipe(plugins.uglify())
        .pipe(plugins.rename("global.min.js"))
        .pipe(gulp.dest("./dist/scripts/"))
        .pipe(plugins.gzip())
        .pipe(gulp.dest("./dist/scripts/"));
});


// css合并，压缩文件
gulp.task("build-global-css", function() {
    gulp.src(buildGlobalCssFiles)
        .pipe(plugins.concat("global.src.css"))
        .pipe(plugins.minifyCss())
        .pipe(plugins.rename("global.min.css"))
        .pipe(gulp.dest("./dist/styles/"))
        .pipe(plugins.gzip())
        .pipe(gulp.dest("./dist/styles/"));
});


//清除css样式
gulp.task("clean-all-css", function(){
    gulp.src("./dist/styles/*.css",{ read:false })
        .pipe(plugins.clean());
});

//清除js样式
gulp.task("clean-all-js", function(){
    gulp.src("./dist/scripts/*.js", { read:false })
        .pipe(plugins.clean());
});

//清除css样式
gulp.task("clean-local-css", function(){
    gulp.src("./dist/**/local.min.css", { read:false })
        .pipe(plugins.clean());
});

//清除js样式
gulp.task("clean-local-js", function(){
    gulp.src("./dist/**/local.min.js", { read:false })
        .pipe(plugins.clean());
});

// css合并，压缩文件
gulp.task("build-local-less",["clean-local-css"], function() {
    gulp.src(["./styles/xn-style-common.less","./styles/"+demoName+".less"])
        .pipe(plugins.concat("local.src.less"))
        .pipe(plugins.less())
     //   .pipe(plugins.minifyCss())
        .pipe(plugins.rename("local.min.css"))
        .pipe(gulp.dest("./dist/styles/"))
        .pipe(plugins.gzip())
        .pipe(gulp.dest("./dist/styles/"));

});

//清除css样式
gulp.task("clean-print-css", function(){
    gulp.src(["./dist/**/print.min.css"], { read:false })
        .pipe(plugins.clean());
    console.log("clean-print-css");
});

// css合并，压缩文件
gulp.task("build-print-less",["clean-print-css"], function() {
    gulp.src(["./spm_modules/bootstrap-css/"+bootstrapCssVersion+"/bootstrap.css", "./styles/print.less"])
        .pipe(plugins.less())
        .pipe(plugins.concat("print.src.css"))
        .pipe(plugins.minifyCss())
        .pipe(plugins.rename("print.min.css"))
        .pipe(gulp.dest("./dist/styles/"))
        .pipe(plugins.gzip())
        .pipe(gulp.dest("./dist/styles/"));
    console.log("build-print-less");

});
// css合并，压缩文件
gulp.task("build-print-css",["build-print-less"], function() {
    gulp.src(["./spm_modules/bootstrap-css/"+bootstrapCssVersion+"/bootstrap.css","./temp/print.css"])
        .pipe(plugins.concat("print.src.css"))
        .pipe(plugins.minifyCss())
        .pipe(plugins.rename("print.min.css"))
        .pipe(gulp.dest("./dist/styles/"))
        .pipe(plugins.gzip())
        .pipe(gulp.dest("./dist/styles/"));
    console.log("build-print-css");

});


gulp.task("build-markdownsetting-js", function () {
    gulp.src(mardownSettingFiles)
        .pipe(plugins.concat("markdownsetting.src.js"))
        .pipe(plugins.uglify())
        .pipe(plugins.rename("markdownsetting.min.js"))
        .pipe(gulp.dest("./dist/scripts/"))
        .pipe(plugins.gzip())
        .pipe(gulp.dest("./dist/scripts/"));
});



gulp.task("build-local-js",["clean-local-js"],function() {
    gulp.src(buildLocalFiles)
        .pipe(plugins.concat("local.src.js"))
        //.pipe(plugins.uglify())
        .pipe(plugins.rename("local.min.js"))
        .pipe(gulp.dest("./dist/scripts/"))
        .pipe(plugins.gzip())
        .pipe(gulp.dest("./dist/scripts/"));
});

gulp.task("watch", function() {
    // gulp.watch("scripts/*.js",["lint",browserSync.reload]);
    gulp.watch("styles/"+demoName+".less", ["build-local-less",browserSync.reload]);
    gulp.watch("styles/print.less", ["build-print-less",browserSync.reload]);
    gulp.watch("scripts/**/*.js", ["build-local-js",browserSync.reload]);
    gulp.watch("styles/images/", ["copy-css-images",browserSync.reload]);
    gulp.watch("templates/**/*.vm", ["bs-reload"]);
});

//检查错误代码
gulp.task('lint', function() {
    gulp.src('./scripts/*.js')
        .pipe(plugins.jshint())
        .pipe(plugins.jshint.reporter('default'));
});

//浏览器同步
gulp.task('browser-sync', function() {
    browserSync({
        proxy: "http://localhost:80"
    });
});

// 定义develop任务在日常开发中使用
gulp.task("clean-all",["clean-all-css","clean-all-js","clean-font","copy-css-images"],function(){
    console.log("运行完成clean-all");
});



// 定义develop任务在日常开发中使用
gulp.task("dev",["build-local-js","build-local-less","copy-cookies-map"],function(){
    console.log("运行完成dev");
});


// Reload all Browsers
gulp.task('bs-reload', function () {
    console.log("浏览器重新加载");
    browserSync.reload();
});


// gulp命令默认启动的就是default认为,这里将clean任务作为依赖,也就是先执行一次clean任务,流程再继续.
gulp.task("default",["browser-sync","clean-all","dev"], function() {

    gulp.run("watch");


});

