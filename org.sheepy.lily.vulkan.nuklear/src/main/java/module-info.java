import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.nuklear.adapter.ButtonAdapter;
import org.sheepy.lily.vulkan.nuklear.adapter.DynamicRowLayoutAdapter;
import org.sheepy.lily.vulkan.nuklear.adapter.LabelAdapter;
import org.sheepy.lily.vulkan.nuklear.adapter.PanelAdapter;
import org.sheepy.lily.vulkan.nuklear.adapter.SliderAdapter;
import org.sheepy.lily.vulkan.nuklear.adapter.VariableLabelAdapter;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearConstantsAdapter;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearPipelineAdapter;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearVertexBufferAdapter;

module org.sheepy.lily.vulkan.nuklear
{
	requires transitive org.sheepy.lily.vulkan.resource;
	requires transitive org.sheepy.lily.vulkan.api;
	requires transitive org.sheepy.lily.vulkan.process;
	requires transitive org.sheepy.lily.vulkan.process.graphic;

	requires transitive org.lwjgl.nuklear;
	requires org.lwjgl.nuklear.natives;

	exports org.sheepy.lily.vulkan.nuklear.adapter;
	exports org.sheepy.lily.vulkan.nuklear.model;
	exports org.sheepy.lily.vulkan.nuklear.model.impl;
	exports org.sheepy.lily.vulkan.nuklear.model.util;

	opens org.sheepy.lily.vulkan.nuklear.adapter;
	opens org.sheepy.lily.vulkan.nuklear.pipeline;

	provides IAdapter with NuklearPipelineAdapter, NuklearConstantsAdapter,
			NuklearVertexBufferAdapter, ButtonAdapter, PanelAdapter, LabelAdapter,
			DynamicRowLayoutAdapter, VariableLabelAdapter, SliderAdapter;

}
