(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        'ui.bootstrap',
         'uiGmapgoogle-maps',
        // Internal modules dependencies  
        'reservaModule',
        'facturaModule',
        'estudianteModule',
        'origenModule',
        'universidadModule',
        'ubicacionModule',
        'arrendadorModule',
        'hospedajeModule',
        'loginModule',
        'homeModule'
    ]);
    //Resuelve problemas
    app.config(['$qProvider','uiGmapGoogleMapApiProvider', function ($qProvider,uiGmapGoogleMapApiProvider) {
               uiGmapGoogleMapApiProvider.configure({
                 key: 'AIzaSyAGX2fd-BcdoHwrTtZbtrcxNM9j7WUrxSY',
                 v: '3.20', //defaults to latest 3.X anyhow
                 libraries: 'weather,geometry,visualization,places'
        });
            $qProvider.errorOnUnhandledRejections(false);
        }]);
    
    app.controller('appCtrl', ['$scope', '$http', '$state', '$rootScope','$stateProvider','$urlRouterProvider',
        function ($scope, $http, $state, $rootScope, $stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise('/home');
            
        }
    ]);
})(window.angular);
