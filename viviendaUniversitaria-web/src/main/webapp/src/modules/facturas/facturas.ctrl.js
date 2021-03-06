(function (ng) {
    var mod = ng.module("facturaModule");
    mod.constant("facturasContext", "api/facturas");
    mod.controller('facturaCtrl', ['$scope', '$http', 'facturasContext', '$state',
        function ($scope, $http, facturasContext, $state) {
            $scope.fechaInicio={value:new Date(2010,01,01)};
            $scope.fechaFin={value : new Date(2017,12,12)};
            $scope.isNavCollapsed = true;
            $scope.isCollapsed = false;
            $scope.isCollapsedHorizontal = false;
            $scope.myFilter="date";
            $http.get(facturasContext).then(function (response) {
                $scope.facturasRecords = response.data;
           });
            if (($state.params.facturaId !== undefined) && ($state.params.facturaId !== null)) {
                $http.get(facturasContext + '/' + $state.params.facturaId).then(function (response) {
                    $scope.listaDetallesReserva = response.data.detalleReserva;
                    $scope.listaDetallesServicio = response.data.detalleServicio;
                    $scope.currentFactura = response.data;
                    
                });
            }
            
          $scope.orderByMe = function(x) {
            $scope.myOrderBy = x;
        }
        $scope.filterByMe = function(x) {
            $scope.myFilter = x;
             
            
        }
        $scope.myFunc = function () {
      $scope.filterByMe("date");
      
  }
         $scope.criteriaMatch = function(criteria) {
             
             
               return function( item ) {
                   if(criteria === "date"){
         var ano=item.fecha.slice(0,4);
         var mes=item.fecha.slice(5,7);
         var dia=item.fecha.slice(8,10);
         var diaInicio=$scope.fechaInicio.value.getDate();
         var mesInicio=$scope.fechaInicio.value.getMonth()+1;
         var anoInicio=$scope.fechaInicio.value.getFullYear();
         var diaFin=$scope.fechaFin.value.getDate();
         var mesFin=$scope.fechaFin.value.getMonth()+1;
         var anoFin=$scope.fechaFin.value.getFullYear();
         var fecha=ano+"-"+mes+"-"+dia;
         var fechaInicio=anoInicio+"-"+mesInicio+"-"+diaInicio;
         var fechaFin=anoFin+"-"+mesFin+"-"+diaFin;
        if(fechaInicio<fecha && fecha<fechaFin){
            
           return  true;
        }
        else {
           
            return false;
        }
                   }
                   else{
                       return false;
                   }
    };
  }
            
        }
        
    ]);
}
)(angular);