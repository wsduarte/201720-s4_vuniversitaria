(function (ng) {
    var mod = ng.module("origenModule");
    mod.constant("origenContext", "api/origenes");
    mod.controller('origenCtrl', ['$scope', '$http', 'origenContext', '$state',
        function ($scope, $http,origenContext, $state) {
            $http.get(origenContext).then(function (response) {
                $scope.origenesRecords = response.data;
            });

            if ($state.params.origenesId !== undefined) {
                $http.get(origenContext + '/' + $state.params.origenesId + '/' + 'estudiantes').then(function (response) {
                    $scope.estudiantesOrigin = response.data;
                });
                
                $http.get(origenContext + '/' + $state.params.origenesId).then(function (response) {
                    $scope.currentOrigen = response.data;
                })
                
                ;
            }
        }
    ]);
}
)(angular);