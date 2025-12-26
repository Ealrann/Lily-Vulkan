module org.sheepy.lily.openal.api
{
	requires transitive org.sheepy.lily.game.api;
	requires transitive org.lwjgl.openal;

	exports org.sheepy.lily.openal.model.openal;

	provides org.sheepy.lily.core.api.resource.IModelExtension with org.sheepy.lily.openal.api.model.OpenALModelExtension;
}
