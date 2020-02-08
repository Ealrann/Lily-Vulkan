import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.openal.api.model.OpenALModelExtension;

module org.sheepy.lily.openal.api
{
	requires transitive org.sheepy.lily.game.api;
	requires transitive org.lwjgl.openal;

	exports org.sheepy.lily.openal.model.openal;
	exports org.sheepy.lily.openal.model.openal.impl;
	exports org.sheepy.lily.openal.model.openal.util;

	provides IModelExtension with OpenALModelExtension;
}
