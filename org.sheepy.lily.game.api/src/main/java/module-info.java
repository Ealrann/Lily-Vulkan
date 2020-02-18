module org.sheepy.lily.game.api
{
	requires transitive org.sheepy.lily.core.api;
	requires transitive org.lwjgl;

	exports org.sheepy.lily.game.api.allocation;
	exports org.sheepy.lily.game.api.audio;
	exports org.sheepy.lily.game.api.resource.buffer;
	exports org.sheepy.lily.game.api.resource.image;
	exports org.sheepy.lily.game.api.window;
}
