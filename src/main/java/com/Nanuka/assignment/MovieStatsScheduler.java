package com.Nanuka.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MovieStatsScheduler {

    private static final Logger logger = LoggerFactory.getLogger(MovieStatsScheduler.class);

    private final MovieRepository movieRepository;

    public MovieStatsScheduler(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Scheduled(fixedRate = 30000)
    public void logMovieCount() {
        long movieCount = movieRepository.count();
        logger.info("Scheduled movie count check: {} movies saved", movieCount);
    }
}
