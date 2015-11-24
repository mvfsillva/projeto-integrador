'use strict';

  var gulp        = require('gulp'),
      stylus      = require('gulp-stylus'),
      uglify      = require('gulp-uglify'),
      concat      = require('gulp-concat'),
      plumber     = require('gulp-plumber'),
      jeet        = require('jeet'),
      koutoSwiss  = require('kouto-swiss'),
      rupture      = require('rupture'),
      prefixer    = require('autoprefixer-stylus'),
      imagemin    = require('gulp-imagemin'),
      cp          = require('child_process');

    gulp.task('stylus', function() {
        gulp.src('assets/stylus/main.styl')
        .pipe(plumber())
        .pipe(stylus({
            use:[jeet(), prefixer(), koutoSwiss(), rupture()],
              compress: true
          }))
        .pipe(gulp.dest('../assets/css'))
    });

  gulp.task('js', function(){
	   return gulp.src('/_src/js/**/*.js')
		.pipe(plumber())
		.pipe(concat('main.js'))
		.pipe(uglify())
		.pipe(gulp.dest('/assets/js/'))
  });

// gulp.task('imagemin', function() {
// 	return gulp.src('./_src/images/**/*.{jpg,png,gif}')
// 		.pipe(plumber())
// 		.pipe(imagemin({ optimizationLevel: 3, progressive: true, interlaced: true }))
// 		.pipe(gulp.dest('assets/img/'));
// });

gulp.task('watch', function () {
	gulp.watch('assets/stylus/**/*.styl', ['stylus']);
	gulp.watch('assets/javascript/**/*.js', ['js']);
	// gulp.watch('./_src/images/**/*.{jpg,png,gif}', ['imagemin']);
});

gulp.task('default', ['stylus', 'js', 'watch']);
