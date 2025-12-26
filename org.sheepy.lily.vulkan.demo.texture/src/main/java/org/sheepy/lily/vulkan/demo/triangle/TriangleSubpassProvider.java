package org.sheepy.lily.vulkan.demo.triangle;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.application.GenericScenePart;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.vulkan.api.device.IVulkanApiContext;
import org.sheepy.lily.vulkan.api.view.ICompositor_SubpassProvider;
import org.sheepy.lily.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.lily.vulkan.demo.mesh.MeshSubpassBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;

@ModelExtender(scope = GenericScenePart.class, name = MainTriangle.NAME)
@Adapter(singleton = true)
public class TriangleSubpassProvider implements ICompositor_SubpassProvider<GenericScenePart>
{
	@Override
	public Subpass build(GenericScenePart part, GraphicProcess process, IVulkanApiContext context)
	{
		final var scene = (Scene) part.lmContainer();
		final var size = scene.size();
		final var meshBuilder = new TriangleMeshBuilder();
		final var meshConfiguration = new MeshConfiguration(meshBuilder, size);

		final var builder = new MeshSubpassBuilder(meshConfiguration);
		return builder.build(process);
	}
}
