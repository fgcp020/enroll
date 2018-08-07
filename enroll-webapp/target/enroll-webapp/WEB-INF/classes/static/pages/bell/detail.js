myApp.controller('bellDetailController', function ($rootScope, $scope, services, $sce, $stateParams) {
    $scope.services = services;
    services["_load_Data"] = function (param) {
        return $rootScope.serverAction(ctxPath + '/site/getArticleDetail', param, "POST");
    };
    $scope.row={};
    $scope.load = function () {
        if ($stateParams.id && $stateParams.id != "") {
            services._load_Data({article_id:$stateParams.id}).success(function (res) {
                $scope.row=res.data;
                $scope.row.article_content=$sce.trustAsHtml(res.data.article_content)
            })
        }
    };
    $scope.load();
});