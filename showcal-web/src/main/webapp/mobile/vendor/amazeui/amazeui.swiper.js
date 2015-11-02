/*! Amaze UI Plugin ~ swiper */

'use strict';

var $ = require('jquery');
var Swiper = require('swiper/dist/js/swiper.jquery');

var old = $.fn.swiper;

$.fn.swiper = function(option) {
  var args = Array.prototype.slice.call(arguments, 1);
  var methodReturn;

  var $set = this.each(function() {
    var $this = $(this);
    var instance = $this.data('swiper');
    var options = typeof option === 'object' && option || {};

    if (!instance) {
      new Swiper(this, options);
    }

    if (typeof option === 'string' && instance[option] !== undefined) {
      methodReturn = (typeof instance[option] === 'function') ?
        instance[option].apply(instance, args) : instance[option];
    }
  });

  return (methodReturn === undefined) ? $set : methodReturn;
};

$.fn.swiper.Constructor = Swiper;

$.fn.swiper.noConflict = function() {
  $.fn.tree = old;
  return this;
};

module.exports = Swiper;
