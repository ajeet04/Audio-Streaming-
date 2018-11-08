package com.assignment.crownstack.crownstackassignment;

public class Model{

    String wrapperType;
    String artistId;
    String collectionId ;
    String artistName;
    String collectionName;
    String trackName;
    String collectionCensoredName ;
    String trackCensoredName;
    String artistViewUrl;
    String collectionViewUrl;
    String trackViewUrl;
    String previewUrl;
    String artworkUrl30 ;
    String artworkUrl60;
    String artworkUrl100 ;
    String collectionPrice;
    String collectionExplicitness ;
    String releaseDate ;
    String trackExplicitness;
    String discCount ;
    String discNumber ;
    String trackCount;
    String trackTimeMillis;
    String country ;
    String currency ;
    String primaryGenreName;
    String isStreamable;



public Model( String wrapperType, String artistId ,String collectionId, String artistName, String collectionName ,String trackName,
        String collectionCensoredName ,String trackCensoredName, String artistViewUrl, String collectionViewUrl ,String trackViewUrl,
        String previewUrl, String artworkUrl30, String artworkUrl60 ,String artworkUrl100, String collectionPrice,
        String collectionExplicitness, String releaseDate, String trackExplicitness, String discCount, String discNumber,  String trackCount,
        String trackTimeMillis, String country ,String currency, String primaryGenreName ,String isStreamable

){
    this.wrapperType=wrapperType;
    this.artistId=artistId;
    this.collectionId=collectionId;
    this.artistName=artistName;
    this.collectionName=collectionName;
    this.trackName=trackName;
    this.collectionCensoredName=collectionCensoredName;
    this.trackCensoredName=trackCensoredName;
    this.artistViewUrl=artistViewUrl;
    this.collectionViewUrl=collectionViewUrl;
    this.trackViewUrl=trackViewUrl;
    this.previewUrl=previewUrl;
    this.artworkUrl30=artworkUrl30;
    this.artworkUrl60=artworkUrl60;
    this.artworkUrl100=artworkUrl100;
    this.collectionPrice=collectionPrice;
    this.collectionExplicitness=collectionExplicitness;
    this.releaseDate=releaseDate;
    this.trackExplicitness=trackExplicitness;
    this.discCount=discCount;
    this.discNumber=discNumber;
    this.trackCount=trackCount;
    this.trackTimeMillis=trackTimeMillis;
    this.country=country;
    this.currency=currency;
    this.primaryGenreName=primaryGenreName;
    this.isStreamable=isStreamable;

}
public Model(){}

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(String collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDiscCount() {
        return discCount;
    }

    public void setDiscCount(String discCount) {
        this.discCount = discCount;
    }

    public String getDiscNumber() {
        return discNumber;
    }

    public String getIsStreamable() {
        return isStreamable;
    }

    public void setIsStreamable(String isStreamable) {
        this.isStreamable = isStreamable;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public String getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(String trackCount) {
        this.trackCount = trackCount;
    }

    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    public void setDiscNumber(String discNumber) {
        this.discNumber = discNumber;
    }

    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(String trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

}

