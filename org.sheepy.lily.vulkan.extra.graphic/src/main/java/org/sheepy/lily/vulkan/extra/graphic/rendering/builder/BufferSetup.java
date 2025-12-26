package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.sheepy.lily.vulkan.extra.model.rendering.DataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;

public record BufferSetup(BufferViewer bufferViewer, DataProvider<?> dataProvider)
{
}
