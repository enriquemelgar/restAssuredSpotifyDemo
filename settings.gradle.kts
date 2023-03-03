rootProject.name = "restAssuredSpotifyDemo"
include("src:test:config")
findProject(":src:test:config")?.name = "config"
