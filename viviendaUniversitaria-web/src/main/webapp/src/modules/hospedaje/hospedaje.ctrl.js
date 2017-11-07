(function (ng) {
    var mod = ng.module("hospedajeModule");
    mod.constant("hospedajeContext", "api/hospedajes");
    mod.controller('hospedajeCtrl', ['$scope', '$http', 'hospedajeContext', '$state',
        function ($scope, $http, hospedajeContext, $state) {


            $http.get(hospedajeContext).then(function (response) {
                $scope.hospedajeList = response.data;
            });

            if ($state.params.idHospedaje !== undefined) {
                $http.get(hospedajeContext + '/' + $state.params.idHospedaje).then(function (response) {
                    $scope.hospedajeActivo = response.data;
                });
            }
            ;
            if ($state.params.idServicio !== undefined) {
                $http.get(hospedajeContext + '/' + $state.params.idHospedaje + '/servicios/' + $state.params.idServicio).then(function (response) {
                    $scope.servicioActivo = response.data;
                });
            }
            ;
            
            if ($state.params.idCalificacion !== undefined) {
                $http.get(hospedajeContext + '/' + $state.params.idHospedaje + '/calificaciones/' + $state.params.idCalificacion).then(function (response) {
                    $scope.calificacionActivo = response.data;
                });
            }
            ;
            
            $scope.eliminarRegla = function (idHospedaje, idRegla) {
                $http.delete(hospedajeContext + '/' + idHospedaje + '/reglas/' + idRegla).then(function (response) {
                    $http.get(hospedajeContext + '/' + $state.params.idHospedaje).then(function (response) {
                        $scope.hospedajeActivo = response.data;
                    });
                    $state.reload();
                });

            };
            $scope.crearRegla = function () {
                $http.post(hospedajeContext + '/' + $state.params.idHospedaje + '/reglas', {
                    regla:$scope.regla
                }).then(function (response) {
                    $state.go('hospedajeEspecifico', {idHospedaje: $state.params.idHospedaje});
                });
            };
            $scope.actualizarServicio = function(idHospedaje, idServicio)
            {
                if($scope.costo===undefined)
                {
                    $scope.costo = $scope.servicioActivo.costo;
                }  
                $http.put(hospedajeContext + '/' +  idHospedaje + '/servicios/'+ idServicio ,{
                    descripcion : $scope.descripcion,
                    costo : $scope.costo
                }).then(function(response) {
                    $state.go('hospedajeEspecifico', {idHospedaje: $state.params.idHospedaje});
                });
            };
            $scope.actualServicioId = $state.params.idServicio;
            $scope.eliminarServicio =function()
            {
                $http.delete(hospedajeContext + '/' + $state.params.idHospedaje + '/servicios/'+ $state.params.idServicio
                ).then(function(response) {
                    $state.go('hospedajeEspecifico', {idHospedaje: $state.params.idHospedaje});
                });
            };
            $scope.crearServicio = function(){
                $http.post(hospedajeContext + '/' +  $state.params.idHospedaje + '/servicios',{
                    id : 9,
                    descripcion : $scope.descripcion,
                    costo : $scope.costos
                }).then(function(response) {
                    $state.go('hospedajeEspecifico', {idHospedaje: $state.params.idHospedaje});
                });
            };
            
            $scope.actualCalificacionId = $state.params.idCalificacion;
            $scope.eliminarCalificacion =function()
            {
                $http.delete(hospedajeContext + '/' + $state.params.idHospedaje + '/calificaciones/'+ $state.params.idCalificacion
                ).then(function(response) {
                    $state.go('hospedajeEspecifico', {idHospedaje: $state.params.idHospedaje});
                });
            };
            $scope.crearCalificacion = function(){
                $http.post(hospedajeContext + '/' +  $state.params.idHospedaje + '/calificaciones',{
                    id : $scope.id,
                    valoracion : $scope.valoracion,
                    comentario : $scope.comentario,
                    fecha: $scope.fecha
                }).then(function(response) {
                    $state.go('hospedajeEspecifico', {idHospedaje: $state.params.idHospedaje});
                });
            };
        }
    ]);
}
)(angular);