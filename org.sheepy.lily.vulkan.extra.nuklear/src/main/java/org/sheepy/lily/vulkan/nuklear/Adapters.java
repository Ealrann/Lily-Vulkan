package org.sheepy.lily.vulkan.nuklear;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.nuklear.dataprovider.NuklearIndexProviderAdapter;
import org.sheepy.lily.vulkan.nuklear.dataprovider.NuklearVertexProviderAdapter;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearFillBufferTaskAdapter;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearLayoutTaskAdapter;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearPushConstantsAdapter;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearFontAdapter;
import org.sheepy.lily.vulkan.nuklear.resource.NullTextureAdapter;
import org.sheepy.lily.vulkan.nuklear.scene.NuklearSubpassProvider;
import org.sheepy.lily.vulkan.nuklear.ui.ButtonAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.DynamicRowLayoutAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.LabelAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.PanelAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.PanelViewerAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.SelectorPanelAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.SliderAdapter;
import org.sheepy.lily.vulkan.nuklear.ui.VariableLabelAdapter;

public class Adapters implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(	ButtonAdapter.class,
						PanelAdapter.class,
						LabelAdapter.class,
						DynamicRowLayoutAdapter.class,
						VariableLabelAdapter.class,
						SliderAdapter.class,
						NullTextureAdapter.class,
						NuklearLayoutTaskAdapter.class,
						NuklearFillBufferTaskAdapter.class,
						NuklearContextAdapter.class,
						NuklearFontAdapter.class,
						NuklearPushConstantsAdapter.class,
						SelectorPanelAdapter.class,
						PanelViewerAdapter.class,
						NuklearVertexProviderAdapter.class,
						NuklearIndexProviderAdapter.class,
						NuklearSubpassProvider.class);
	}
}
