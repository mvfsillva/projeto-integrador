'use strict';

  var gulp        = require('gulp'),
      stylus      = require('gulp-stylus'),
      uglify      = require('gulp-uglify'),
      concat      = require('gulp-concat'),
      plumber     = require('gulp-plumber'),
      jeet        = require('jeet'),
      koutoSwiss  = require('kouto-swiss'),
      prefixer    = require('autoprefixer-stylus'),
      imagemin    = require('gulp-imagemin'),
      cp          = require('child_process');

  gulp.task('less', function(){
    gulp.src('./_src/less/main.less')
    .pipe(less({ compress: true }))
    .pipe(gulp.dest('./assets/css'))
  });
