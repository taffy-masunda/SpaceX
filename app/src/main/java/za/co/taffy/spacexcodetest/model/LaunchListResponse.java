package za.co.taffy.spacexcodetest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaunchListResponse {

    @SerializedName("flight_number")
    @Expose
    private Integer flightNumber;
    @SerializedName("mission_name")
    @Expose
    private String missionName;
    @SerializedName("mission_id")
    @Expose
    private List<Object> missionId = null;
    @SerializedName("upcoming")
    @Expose
    private Boolean upcoming;
    @SerializedName("launch_year")
    @Expose
    private String launchYear;
    @SerializedName("launch_date_unix")
    @Expose
    private Integer launchDateUnix;
    @SerializedName("launch_date_utc")
    @Expose
    private String launchDateUtc;
    @SerializedName("launch_date_local")
    @Expose
    private String launchDateLocal;
    @SerializedName("is_tentative")
    @Expose
    private Boolean isTentative;
    @SerializedName("tentative_max_precision")
    @Expose
    private String tentativeMaxPrecision;
    @SerializedName("tbd")
    @Expose
    private Boolean tbd;
    @SerializedName("launch_window")
    @Expose
    private Integer launchWindow;
    @SerializedName("rocket")
    @Expose
    private Rocket rocket;
    @SerializedName("ships")
    @Expose
    private List<Object> ships = null;
    @SerializedName("telemetry")
    @Expose
    private Telemetry telemetry;
    @SerializedName("launch_site")
    @Expose
    private LaunchSite launchSite;
    @SerializedName("launch_success")
    @Expose
    private Boolean launchSuccess;
    @SerializedName("launch_failure_details")
    @Expose
    private LaunchFailureDetails launchFailureDetails;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("static_fire_date_utc")
    @Expose
    private String staticFireDateUtc;
    @SerializedName("static_fire_date_unix")
    @Expose
    private Integer staticFireDateUnix;
    @SerializedName("timeline")
    @Expose
    private Timeline timeline;
    @SerializedName("crew")
    @Expose
    private Object crew;

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public List<Object> getMissionId() {
        return missionId;
    }

    public void setMissionId(List<Object> missionId) {
        this.missionId = missionId;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public Integer getLaunchDateUnix() {
        return launchDateUnix;
    }

    public void setLaunchDateUnix(Integer launchDateUnix) {
        this.launchDateUnix = launchDateUnix;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public void setLaunchDateLocal(String launchDateLocal) {
        this.launchDateLocal = launchDateLocal;
    }

    public Boolean getIsTentative() {
        return isTentative;
    }

    public void setIsTentative(Boolean isTentative) {
        this.isTentative = isTentative;
    }

    public String getTentativeMaxPrecision() {
        return tentativeMaxPrecision;
    }

    public void setTentativeMaxPrecision(String tentativeMaxPrecision) {
        this.tentativeMaxPrecision = tentativeMaxPrecision;
    }

    public Boolean getTbd() {
        return tbd;
    }

    public void setTbd(Boolean tbd) {
        this.tbd = tbd;
    }

    public Integer getLaunchWindow() {
        return launchWindow;
    }

    public void setLaunchWindow(Integer launchWindow) {
        this.launchWindow = launchWindow;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public List<Object> getShips() {
        return ships;
    }

    public void setShips(List<Object> ships) {
        this.ships = ships;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public Boolean getLaunchSuccess() {
        return launchSuccess;
    }

    public void setLaunchSuccess(Boolean launchSuccess) {
        this.launchSuccess = launchSuccess;
    }

    public LaunchFailureDetails getLaunchFailureDetails() {
        return launchFailureDetails;
    }

    public void setLaunchFailureDetails(LaunchFailureDetails launchFailureDetails) {
        this.launchFailureDetails = launchFailureDetails;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStaticFireDateUtc() {
        return staticFireDateUtc;
    }

    public void setStaticFireDateUtc(String staticFireDateUtc) {
        this.staticFireDateUtc = staticFireDateUtc;
    }

    public Integer getStaticFireDateUnix() {
        return staticFireDateUnix;
    }

    public void setStaticFireDateUnix(Integer staticFireDateUnix) {
        this.staticFireDateUnix = staticFireDateUnix;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public Object getCrew() {
        return crew;
    }

    public void setCrew(Object crew) {
        this.crew = crew;
    }

    /* pLaunchFailureDetails sub-class */
    public class LaunchFailureDetails {
        @SerializedName("time")
        @Expose
        private Integer time;
        @SerializedName("altitude")
        @Expose
        private Object altitude;
        @SerializedName("reason")
        @Expose
        private String reason;

        public Integer getTime() {
            return time;
        }

        public void setTime(Integer time) {
            this.time = time;
        }

        public Object getAltitude() {
            return altitude;
        }

        public void setAltitude(Object altitude) {
            this.altitude = altitude;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    /* LaunchSite sub-class */
    public class LaunchSite {
        @SerializedName("site_id")
        @Expose
        private String siteId;
        @SerializedName("site_name")
        @Expose
        private String siteName;
        @SerializedName("site_name_long")
        @Expose
        private String siteNameLong;

        public String getSiteId() {
            return siteId;
        }

        public void setSiteId(String siteId) {
            this.siteId = siteId;
        }

        public String getSiteName() {
            return siteName;
        }

        public void setSiteName(String siteName) {
            this.siteName = siteName;
        }

        public String getSiteNameLong() {
            return siteNameLong;
        }

        public void setSiteNameLong(String siteNameLong) {
            this.siteNameLong = siteNameLong;
        }
    }

    /* Links sub-class */
    public class Links {

        @SerializedName("mission_patch")
        @Expose
        private String missionPatch;
        @SerializedName("mission_patch_small")
        @Expose
        private String missionPatchSmall;
        @SerializedName("reddit_campaign")
        @Expose
        private Object redditCampaign;
        @SerializedName("reddit_launch")
        @Expose
        private Object redditLaunch;
        @SerializedName("reddit_recovery")
        @Expose
        private Object redditRecovery;
        @SerializedName("reddit_media")
        @Expose
        private Object redditMedia;
        @SerializedName("presskit")
        @Expose
        private Object presskit;
        @SerializedName("article_link")
        @Expose
        private String articleLink;
        @SerializedName("wikipedia")
        @Expose
        private String wikipedia;
        @SerializedName("video_link")
        @Expose
        private String videoLink;
        @SerializedName("youtube_id")
        @Expose
        private String youtubeId;
        @SerializedName("flickr_images")
        @Expose
        private List<Object> flickrImages = null;

        public String getMissionPatch() {
            return missionPatch;
        }

        public void setMissionPatch(String missionPatch) {
            this.missionPatch = missionPatch;
        }

        public String getMissionPatchSmall() {
            return missionPatchSmall;
        }

        public void setMissionPatchSmall(String missionPatchSmall) {
            this.missionPatchSmall = missionPatchSmall;
        }

        public Object getRedditCampaign() {
            return redditCampaign;
        }

        public void setRedditCampaign(Object redditCampaign) {
            this.redditCampaign = redditCampaign;
        }

        public Object getRedditLaunch() {
            return redditLaunch;
        }

        public void setRedditLaunch(Object redditLaunch) {
            this.redditLaunch = redditLaunch;
        }

        public Object getRedditRecovery() {
            return redditRecovery;
        }

        public void setRedditRecovery(Object redditRecovery) {
            this.redditRecovery = redditRecovery;
        }

        public Object getRedditMedia() {
            return redditMedia;
        }

        public void setRedditMedia(Object redditMedia) {
            this.redditMedia = redditMedia;
        }

        public Object getPresskit() {
            return presskit;
        }

        public void setPresskit(Object presskit) {
            this.presskit = presskit;
        }

        public String getArticleLink() {
            return articleLink;
        }

        public void setArticleLink(String articleLink) {
            this.articleLink = articleLink;
        }

        public String getWikipedia() {
            return wikipedia;
        }

        public void setWikipedia(String wikipedia) {
            this.wikipedia = wikipedia;
        }

        public String getVideoLink() {
            return videoLink;
        }

        public void setVideoLink(String videoLink) {
            this.videoLink = videoLink;
        }

        public String getYoutubeId() {
            return youtubeId;
        }

        public void setYoutubeId(String youtubeId) {
            this.youtubeId = youtubeId;
        }

        public List<Object> getFlickrImages() {
            return flickrImages;
        }

        public void setFlickrImages(List<Object> flickrImages) {
            this.flickrImages = flickrImages;
        }
    }

    /* Rocket sub-class */
    public class Rocket {

        @SerializedName("rocket_id")
        @Expose
        private String rocketId;
        @SerializedName("rocket_name")
        @Expose
        private String rocketName;
        @SerializedName("rocket_type")
        @Expose
        private String rocketType;
        @SerializedName("first_stage")
        @Expose
        private FirstStage firstStage;
        @SerializedName("second_stage")
        @Expose
        private SecondStage secondStage;
        @SerializedName("fairings")
        @Expose
        private Fairings fairings;

        public String getRocketId() {
            return rocketId;
        }

        public void setRocketId(String rocketId) {
            this.rocketId = rocketId;
        }

        public String getRocketName() {
            return rocketName;
        }

        public void setRocketName(String rocketName) {
            this.rocketName = rocketName;
        }

        public String getRocketType() {
            return rocketType;
        }

        public void setRocketType(String rocketType) {
            this.rocketType = rocketType;
        }

        public FirstStage getFirstStage() {
            return firstStage;
        }

        public void setFirstStage(FirstStage firstStage) {
            this.firstStage = firstStage;
        }

        public SecondStage getSecondStage() {
            return secondStage;
        }

        public void setSecondStage(SecondStage secondStage) {
            this.secondStage = secondStage;
        }

        public Fairings getFairings() {
            return fairings;
        }

        public void setFairings(Fairings fairings) {
            this.fairings = fairings;
        }

    }

    /* Fairing sub-class */
    public class Fairings {

        @SerializedName("reused")
        @Expose
        private Boolean reused;
        @SerializedName("recovery_attempt")
        @Expose
        private Boolean recoveryAttempt;
        @SerializedName("recovered")
        @Expose
        private Boolean recovered;
        @SerializedName("ship")
        @Expose
        private Object ship;

        public Boolean getReused() {
            return reused;
        }

        public void setReused(Boolean reused) {
            this.reused = reused;
        }

        public Boolean getRecoveryAttempt() {
            return recoveryAttempt;
        }

        public void setRecoveryAttempt(Boolean recoveryAttempt) {
            this.recoveryAttempt = recoveryAttempt;
        }

        public Boolean getRecovered() {
            return recovered;
        }

        public void setRecovered(Boolean recovered) {
            this.recovered = recovered;
        }

        public Object getShip() {
            return ship;
        }

        public void setShip(Object ship) {
            this.ship = ship;
        }

    }

    /* Core sub-class */
    public class Core {

        @SerializedName("core_serial")
        @Expose
        private String coreSerial;
        @SerializedName("flight")
        @Expose
        private Integer flight;
        @SerializedName("block")
        @Expose
        private Object block;
        @SerializedName("gridfins")
        @Expose
        private Boolean gridfins;
        @SerializedName("legs")
        @Expose
        private Boolean legs;
        @SerializedName("reused")
        @Expose
        private Boolean reused;
        @SerializedName("land_success")
        @Expose
        private Object landSuccess;
        @SerializedName("landing_intent")
        @Expose
        private Boolean landingIntent;
        @SerializedName("landing_type")
        @Expose
        private Object landingType;
        @SerializedName("landing_vehicle")
        @Expose
        private Object landingVehicle;

        public String getCoreSerial() {
            return coreSerial;
        }

        public void setCoreSerial(String coreSerial) {
            this.coreSerial = coreSerial;
        }

        public Integer getFlight() {
            return flight;
        }

        public void setFlight(Integer flight) {
            this.flight = flight;
        }

        public Object getBlock() {
            return block;
        }

        public void setBlock(Object block) {
            this.block = block;
        }

        public Boolean getGridfins() {
            return gridfins;
        }

        public void setGridfins(Boolean gridfins) {
            this.gridfins = gridfins;
        }

        public Boolean getLegs() {
            return legs;
        }

        public void setLegs(Boolean legs) {
            this.legs = legs;
        }

        public Boolean getReused() {
            return reused;
        }

        public void setReused(Boolean reused) {
            this.reused = reused;
        }

        public Object getLandSuccess() {
            return landSuccess;
        }

        public void setLandSuccess(Object landSuccess) {
            this.landSuccess = landSuccess;
        }

        public Boolean getLandingIntent() {
            return landingIntent;
        }

        public void setLandingIntent(Boolean landingIntent) {
            this.landingIntent = landingIntent;
        }

        public Object getLandingType() {
            return landingType;
        }

        public void setLandingType(Object landingType) {
            this.landingType = landingType;
        }

        public Object getLandingVehicle() {
            return landingVehicle;
        }

        public void setLandingVehicle(Object landingVehicle) {
            this.landingVehicle = landingVehicle;
        }
    }

    /* FirstStage sub-class */
    public class FirstStage {

        @SerializedName("cores")
        @Expose
        private List<Core> cores = null;

        public List<Core> getCores() {
            return cores;
        }

        public void setCores(List<Core> cores) {
            this.cores = cores;
        }

    }

    /* Payload sub-class */
    public class Payload {

        @SerializedName("payload_id")
        @Expose
        private String payloadId;
        @SerializedName("norad_id")
        @Expose
        private List<Object> noradId = null;
        @SerializedName("reused")
        @Expose
        private Boolean reused;
        @SerializedName("customers")
        @Expose
        private List<String> customers = null;
        @SerializedName("nationality")
        @Expose
        private String nationality;
        @SerializedName("manufacturer")
        @Expose
        private String manufacturer;
        @SerializedName("payload_type")
        @Expose
        private String payloadType;
        @SerializedName("payload_mass_kg")
        @Expose
        private Double payloadMassKg;
        @SerializedName("payload_mass_lbs")
        @Expose
        private Double payloadMassLbs;
        @SerializedName("orbit")
        @Expose
        private String orbit;
        @SerializedName("orbit_params")
        @Expose
        private OrbitParams orbitParams;

        public String getPayloadId() {
            return payloadId;
        }

        public void setPayloadId(String payloadId) {
            this.payloadId = payloadId;
        }

        public List<Object> getNoradId() {
            return noradId;
        }

        public void setNoradId(List<Object> noradId) {
            this.noradId = noradId;
        }

        public Boolean getReused() {
            return reused;
        }

        public void setReused(Boolean reused) {
            this.reused = reused;
        }

        public List<String> getCustomers() {
            return customers;
        }

        public void setCustomers(List<String> customers) {
            this.customers = customers;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getPayloadType() {
            return payloadType;
        }

        public void setPayloadType(String payloadType) {
            this.payloadType = payloadType;
        }

        public Double getPayloadMassKg() {
            return payloadMassKg;
        }

        public void setPayloadMassKg(Double payloadMassKg) {
            this.payloadMassKg = payloadMassKg;
        }

        public Double getPayloadMassLbs() {
            return payloadMassLbs;
        }

        public void setPayloadMassLbs(Double payloadMassLbs) {
            this.payloadMassLbs = payloadMassLbs;
        }

        public String getOrbit() {
            return orbit;
        }

        public void setOrbit(String orbit) {
            this.orbit = orbit;
        }

        public OrbitParams getOrbitParams() {
            return orbitParams;
        }

        public void setOrbitParams(OrbitParams orbitParams) {
            this.orbitParams = orbitParams;
        }

    }

    /* Orbit sub-class */
    public class OrbitParams {

        @SerializedName("reference_system")
        @Expose
        private String referenceSystem;
        @SerializedName("regime")
        @Expose
        private String regime;
        @SerializedName("longitude")
        @Expose
        private Object longitude;
        @SerializedName("semi_major_axis_km")
        @Expose
        private Object semiMajorAxisKm;
        @SerializedName("eccentricity")
        @Expose
        private Object eccentricity;
        @SerializedName("periapsis_km")
        @Expose
        private Double periapsisKm;
        @SerializedName("apoapsis_km")
        @Expose
        private Double apoapsisKm;
        @SerializedName("inclination_deg")
        @Expose
        private Double inclinationDeg;
        @SerializedName("period_min")
        @Expose
        private Object periodMin;
        @SerializedName("lifespan_years")
        @Expose
        private Object lifespanYears;
        @SerializedName("epoch")
        @Expose
        private Object epoch;
        @SerializedName("mean_motion")
        @Expose
        private Object meanMotion;
        @SerializedName("raan")
        @Expose
        private Object raan;
        @SerializedName("arg_of_pericenter")
        @Expose
        private Object argOfPericenter;
        @SerializedName("mean_anomaly")
        @Expose
        private Object meanAnomaly;

        public String getReferenceSystem() {
            return referenceSystem;
        }

        public void setReferenceSystem(String referenceSystem) {
            this.referenceSystem = referenceSystem;
        }

        public String getRegime() {
            return regime;
        }

        public void setRegime(String regime) {
            this.regime = regime;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public Object getSemiMajorAxisKm() {
            return semiMajorAxisKm;
        }

        public void setSemiMajorAxisKm(Object semiMajorAxisKm) {
            this.semiMajorAxisKm = semiMajorAxisKm;
        }

        public Object getEccentricity() {
            return eccentricity;
        }

        public void setEccentricity(Object eccentricity) {
            this.eccentricity = eccentricity;
        }

        public Double getPeriapsisKm() {
            return periapsisKm;
        }

        public void setPeriapsisKm(Double periapsisKm) {
            this.periapsisKm = periapsisKm;
        }

        public Double getApoapsisKm() {
            return apoapsisKm;
        }

        public void setApoapsisKm(Double apoapsisKm) {
            this.apoapsisKm = apoapsisKm;
        }

        public Double getInclinationDeg() {
            return inclinationDeg;
        }

        public void setInclinationDeg(Double inclinationDeg) {
            this.inclinationDeg = inclinationDeg;
        }

        public Object getPeriodMin() {
            return periodMin;
        }

        public void setPeriodMin(Object periodMin) {
            this.periodMin = periodMin;
        }

        public Object getLifespanYears() {
            return lifespanYears;
        }

        public void setLifespanYears(Object lifespanYears) {
            this.lifespanYears = lifespanYears;
        }

        public Object getEpoch() {
            return epoch;
        }

        public void setEpoch(Object epoch) {
            this.epoch = epoch;
        }

        public Object getMeanMotion() {
            return meanMotion;
        }

        public void setMeanMotion(Object meanMotion) {
            this.meanMotion = meanMotion;
        }

        public Object getRaan() {
            return raan;
        }

        public void setRaan(Object raan) {
            this.raan = raan;
        }

        public Object getArgOfPericenter() {
            return argOfPericenter;
        }

        public void setArgOfPericenter(Object argOfPericenter) {
            this.argOfPericenter = argOfPericenter;
        }

        public Object getMeanAnomaly() {
            return meanAnomaly;
        }

        public void setMeanAnomaly(Object meanAnomaly) {
            this.meanAnomaly = meanAnomaly;
        }

    }

    /* SecondStage sub-class */
    public class SecondStage {

        @SerializedName("block")
        @Expose
        private Integer block;
        @SerializedName("payloads")
        @Expose
        private List<Payload> payloads = null;

        public Integer getBlock() {
            return block;
        }

        public void setBlock(Integer block) {
            this.block = block;
        }

        public List<Payload> getPayloads() {
            return payloads;
        }

        public void setPayloads(List<Payload> payloads) {
            this.payloads = payloads;
        }

    }

    /* Telemetry sub-class */
    public class Telemetry {

        @SerializedName("flight_club")
        @Expose
        private Object flightClub;

        public Object getFlightClub() {
            return flightClub;
        }

        public void setFlightClub(Object flightClub) {
            this.flightClub = flightClub;
        }

    }

    /* Timeline sub-class */
    public class Timeline {

        @SerializedName("webcast_liftoff")
        @Expose
        private Integer webcastLiftoff;

        public Integer getWebcastLiftoff() {
            return webcastLiftoff;
        }

        public void setWebcastLiftoff(Integer webcastLiftoff) {
            this.webcastLiftoff = webcastLiftoff;
        }

    }
}


