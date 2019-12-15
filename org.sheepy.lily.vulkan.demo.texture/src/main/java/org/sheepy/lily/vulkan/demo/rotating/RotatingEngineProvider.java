package org.sheepy.lily.vulkan.demo.rotating;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.api.view.IViewAdapter;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.presentation.GenericView;
import org.sheepy.lily.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.lily.vulkan.demo.mesh.MeshModelFactory;
import org.sheepy.lily.vulkan.demo.triangle.TriangleMeshBuilder;
import org.sheepy.vulkan.model.enumeration.EFrontFace;

@Adapter(scope = GenericView.class, name = MainRotating.NAME)
public class RotatingEngineProvider implements IViewAdapter<GenericView>
{
	public static int FRAME_COUNT = 0;

	static final String VERTEX_SHADER_PATH = "rotating.vert.spv";
	static final String FRAGMENT_SHADER_PATH = "rotating.frag.spv";

	@Override
	public IEngine buildEngine(GenericView view)
	{
		final var application = ModelUtil.getApplication(view);
		final var size = application.getSize();
		final var meshBuilder = new TriangleMeshBuilder();
		final var meshConfiguration = new MeshConfiguration(meshBuilder, size);
		meshConfiguration.useCamera = true;
		meshConfiguration.vertexShaderPath = VERTEX_SHADER_PATH;
		meshConfiguration.fragmentShaderPath = FRAGMENT_SHADER_PATH;
		meshConfiguration.rasterizerFrontFace = EFrontFace.COUNTER_CLOCKWISE;
		meshConfiguration.frameCount = FRAME_COUNT;
		final var factory = new MeshModelFactory(meshConfiguration);

		return factory.build();
	}
}
