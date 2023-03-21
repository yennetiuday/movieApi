package com.techreturners.movieApi.apiProxy;

import com.techreturners.movieApi.vo.Actors;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.techreturners.movieApi.util.UtilConstants.*;

@Service
@NoArgsConstructor
public class ActorApiProxyImpl extends ApiProxyBase<Actors> implements ActorApiProxy {

    @Override
    public Actors retrieveActors(String name) throws IOException {

        String apiUrl = BASE_URL+ ACTOR_BY_NAME+name;

        return retrieveData(apiUrl);
    }

    @Override
    public Actors retrieveActorDetailsById(String imdbId) throws IOException {
        String apiUrl = BASE_URL+ ACTOR_DETAILS_BY_IMDB_ID+imdbId;

        return retrieveData(apiUrl);
    }

    @Override
    protected Class<Actors> getType() {
        return Actors.class;
    }
}
