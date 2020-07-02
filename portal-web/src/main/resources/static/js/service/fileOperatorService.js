app.service("fileOperatorService",function ($http) {

    this.upload=function () {
        //做一个表单
        var formData=new FormData();
        formData.append("file",file.files[0]);
        //上传文件的anglar.js的方法
        return $http({
            method: "post",
            url: "/file/upload",
            data: formData,
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity,
        });
    }
    this.uploadFile = function(){
        // 向后台传递数据:
        var formData = new FormData();
        // 向formData中添加数据:
        formData.append("file",file.files[0]);

        return $http({
            method:'post',
            url:'/file/upload',
            data:formData,
            headers:{'Content-Type':undefined} ,// Content-Type : text/html  text/plain
            transformRequest: angular.identity
        });
    }
})