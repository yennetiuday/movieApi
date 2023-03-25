package com.techreturners.movieApi.apiProxy;

import com.techreturners.movieApi.vo.Movies;
import com.techreturners.movieApi.vo.Pagination;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static com.techreturners.movieApi.util.UtilConstants.*;

@Service
@NoArgsConstructor
public class MovieApiProxyImpl extends ApiProxyBase<Movies> implements MovieApiProxy {

    @Override
    public Movies retriveMoviesByYear(Long year, Integer page) throws IOException {

        String apiUrl = BASE_URL + MOVIES;
        String apiEndpoint = Objects.nonNull(page)? "/byYear/" + year+"?page="+page : "/byYear/" + year;
        Movies movies = retrieveData(apiUrl+apiEndpoint);
        if(Objects.nonNull(movies) && Objects.nonNull(movies.getLinks())) {
            Pagination links = new Pagination();
            links.setNext(getPaginationLink(movies.getLinks().getNext(), year));
            links.setPrevious(getPaginationLink(movies.getLinks().getPrevious(), year));
            movies.setLinks(links);
        }
        return movies;
    }

    private static String getPaginationLink(String link, Long year) {
        if(Objects.nonNull(link)) {
            MultiValueMap<String, String> params = UriComponentsBuilder.fromUriString(link).build().getQueryParams();
            List<String> pages = params.get("page");
            if(Objects.nonNull(pages) && !pages.isEmpty()) {
                return String.format("%smovie/%s?page=%s", APP_BASE_URL, year, params.get("page").get(0));
            } else {
                return String.format("%smovie/%s", APP_BASE_URL, year);
            }
        }
        return null;
    }

    @Override
    protected Class<Movies> getType() {
        return Movies.class;
    }
}


