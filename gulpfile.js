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


  gulp.task('stylus', function(){
  		gulp.src('_src/stylus/main.styl')
  		.pipe(plumber())
  		.pipe(stylus({
  			use:[koutoSwiss(), prefixer(), jeet(),rupture()],
  			compress: true
  		}))
  		.pipe(gulp.dest('assets/css'))
  });

  gulp.task('js', function(){
	   return gulp.src('src/js/**/*.js')
		.pipe(plumber())
		.pipe(concat('main.js'))
		.pipe(uglify())
		.pipe(gulp.dest('assets/js/'))
  });

gulp.task('imagemin', function() {
	return gulp.src('src/img/**/*.{jpg,png,gif}')
		.pipe(plumber())
		.pipe(imagemin({ optimizationLevel: 3, progressive: true, interlaced: true }))
		.pipe(gulp.dest('assets/img/'));
});

gulp.task('watch', function () {
	gulp.watch('src/styl/**/*.styl', ['stylus']);
	gulp.watch('src/js/**/*.js', ['js']);
	gulp.watch('src/img/**/*.{jpg,png,gif}', ['imagemin']);
});
