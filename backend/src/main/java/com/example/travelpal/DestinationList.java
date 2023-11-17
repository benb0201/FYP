package com.example.travelpal;

import com.example.travelpal.models.Destination;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DestinationList {

    public List<Destination> getDestinations() {
        return List.of(
                paris,
                newYorkCity,
                london,
                tokyo,
                rome,
                sydney,
                dubai,
                rioDeJaneiro,
                amsterdam,
                capeTown
        );
    }

    //List of destinations
    Destination paris = new Destination(
            "Paris",
            "Paris, France",
            "The City of Love"
    );

    Destination newYorkCity = new Destination(
            "New York City",
            "New York, USA",
            "The Big Apple"
    );

    Destination london = new Destination(
            "London",
            "London, United Kingdom",
            "The British Capital"
    );

    Destination tokyo = new Destination(
            "Tokyo",
            "Tokyo, Japan",
            "The Land of the Rising Sun"
    );

    Destination rome = new Destination(
            "Rome",
            "Rome, Italy",
            "The Eternal City"
    );

    Destination sydney = new Destination(
            "Sydney",
            "Sydney, Australia",
            "The Harbour City"
    );

    Destination dubai = new Destination(
            "Dubai",
            "Dubai, United Arab Emirates",
            "The City of Gold"
    );

    Destination rioDeJaneiro = new Destination(
            "Rio de Janeiro",
            "Rio de Janeiro, Brazil",
            "The Marvelous City"
    );

    Destination amsterdam = new Destination(
            "Amsterdam",
            "Amsterdam, Netherlands",
            "The Venice of the North"
    );

    Destination capeTown = new Destination(
            "Cape Town",
            "Cape Town, South Africa",
            "The Mother City"
    );

}