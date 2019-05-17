import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.nuklear.adapter.ButtonAdapter;
import org.sheepy.lily.vulkan.nuklear.adapter.DynamicRowLayoutAdapter;
import org.sheepy.lily.vulkan.nuklear.adapter.LabelAdapter;
import org.sheepy.lily.vulkan.nuklear.adapter.PanelAdapter;
import org.sheepy.lily.vulkan.nuklear.adapter.SliderAdapter;
import org.sheepy.lily.vulkan.nuklear.adapter.VariableLabelAdapter;
import org.sheepy.lily.vulkan.nuklear.builder.NkPipelineBuilderAdapter;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearLayoutTaskAdapter;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearPushConstantsAdapter;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearFontAdapter;
import org.sheepy.lily.vulkan.nuklear.resource.NullTextureAdapter;

@Adapters(classifiers = {
		ButtonAdapter.class,
		PanelAdapter.class,
		LabelAdapter.class,
		DynamicRowLayoutAdapter.class,
		VariableLabelAdapter.class,
		SliderAdapter.class,
		NkPipelineBuilderAdapter.class,
		NullTextureAdapter.class,
		NuklearLayoutTaskAdapter.class,
		NuklearContextAdapter.class,
		NuklearFontAdapter.class,
		NuklearPushConstantsAdapter.class
})

module org.sheepy.lily.vulkan.extra.nuklear
{
	requires transitive org.sheepy.lily.vulkan.extra.api;

	requires transitive org.sheepy.lily.vulkan.process.graphic;

	requires transitive org.lwjgl.nuklear;
	requires org.lwjgl.nuklear.natives;

	exports org.sheepy.lily.vulkan.nuklear.adapter;

	opens org.sheepy.lily.vulkan.nuklear.adapter;
	opens org.sheepy.lily.vulkan.nuklear.builder;
	opens org.sheepy.lily.vulkan.nuklear.pipeline;
	opens org.sheepy.lily.vulkan.nuklear.resource;
}
