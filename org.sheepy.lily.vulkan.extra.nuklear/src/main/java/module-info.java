import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearLayoutTaskAdapter;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearPushConstantsAdapter;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearFontAdapter;
import org.sheepy.lily.vulkan.nuklear.resource.NullTextureAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.ButtonAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.DynamicRowLayoutAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.LabelAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.PanelAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.SliderAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.VariableLabelAdapter;

@Adapters(classifiers = {
		ButtonAdapter.class,
		PanelAdapter.class,
		LabelAdapter.class,
		DynamicRowLayoutAdapter.class,
		VariableLabelAdapter.class,
		SliderAdapter.class,
		NullTextureAdapter.class,
		NuklearLayoutTaskAdapter.class,
		NuklearContextAdapter.class,
		NuklearFontAdapter.class,
		NuklearPushConstantsAdapter.class
})

module org.sheepy.lily.vulkan.extra.nuklear
{
	requires transitive org.sheepy.lily.vulkan.extra.api;

	requires transitive org.lwjgl.nuklear;
	requires org.lwjgl.nuklear.natives;

	exports org.sheepy.lily.vulkan.nuklear.ui;

	opens org.sheepy.lily.vulkan.nuklear.ui;
	opens org.sheepy.lily.vulkan.nuklear.pipeline;
	opens org.sheepy.lily.vulkan.nuklear.resource;
}
