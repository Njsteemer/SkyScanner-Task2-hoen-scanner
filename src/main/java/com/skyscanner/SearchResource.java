package com.skyscanner;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/search")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {

    private List<SearchResult> searchResultLists;

    public SearchResource(List<SearchResult> searchResultLists) {
        this.searchResultLists = searchResultLists;
    }

    @POST
    public List<SearchResult> search(@NotNull @Valid Search search) {
        List<SearchResult> response = new ArrayList<>();
        for (SearchResult result : searchResultLists) {
            if (result.getCity().equals(search.getCity())) {
                response.add(result);
            }
        }
        return response;
    }
}
