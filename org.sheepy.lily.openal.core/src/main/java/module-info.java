import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.openal.core.Adapters;

module org.sheepy.lily.openal.core
{
	requires org.sheepy.lily.openal.api;
	requires org.sheepy.lily.game.core;

	requires org.lwjgl.stb;
	requires org.lwjgl.openal.natives;

	opens org.sheepy.lily.openal.core.engine;
	opens org.sheepy.lily.openal.core.resource;

	provides IAdapterProvider with Adapters;
}
