/**
 * Home component
 * 
 * Created by juncevich on 6/21/17.
 */
angular.module('home', []).controller('home', function($http) {

    var self = this;
    $http.get('/user/').then(function(response) {

        self.user = response.data.name;
    });
});
