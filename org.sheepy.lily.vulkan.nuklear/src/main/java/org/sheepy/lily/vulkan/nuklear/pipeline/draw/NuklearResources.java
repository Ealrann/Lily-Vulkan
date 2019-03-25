package org.sheepy.lily.vulkan.nuklear.pipeline.draw;

import java.util.List;
import java.util.Objects;

import org.lwjgl.nuklear.NkUserFont;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.model.resource.impl.ModuleResourceImpl;
import org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl;
import org.sheepy.lily.vulkan.nuklear.model.NuklearPipeline;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearPipelineAdapter;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearVertexBufferAdapter;
import org.sheepy.lily.vulkan.nuklear.pipeline.NullTexture;
import org.sheepy.lily.vulkan.nuklear.util.NkFontLoader;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.resource.nativehelper.VkDescriptorSet;
import org.sheepy.lily.vulkan.resource.shader.ShaderAdapter;
import org.sheepy.lily.vulkan.resource.texture.FontAdapter;

public class NuklearResources
{
	private final static String GUI_VERT_SHADER = "ui.vert.spv";
	private final static String GUI_FRAG_SHADER = "ui.frag.spv";

	private final NuklearPipeline nkPipeline;

	private NkUserFont defaultFont = null;

	private final NullTexture nullTexture = new NullTexture();
	private final VkDescriptorSet nullDescriptorSet;
	private final VkDescriptorSet fontDescriptorSet;

	private final Shader vertexShader;
	private final Shader fragmentShader;
	private final List<IVkDescriptorSet> descriptors;
	private final List<Shader> shaders;
	private List<Object> resourceList;
	private NkFontLoader fontLoader;

	public NuklearResources(NuklearPipeline nkPipeline)
	{
		this.nkPipeline = nkPipeline;

		final var font = nkPipeline.getFont();
		final var fontAdapter = FontAdapter.adapt(font);

		nullDescriptorSet = new VkDescriptorSet(List.of(nullTexture.texture));
		fontDescriptorSet = new VkDescriptorSet(List.of((IVkDescriptor) fontAdapter));
		descriptors = List.of(nullDescriptorSet, fontDescriptorSet);

		final var module = NuklearPipelineAdapter.class.getModule();

		final var vertexShaderResource = new ModuleResourceImpl();
		vertexShaderResource.setModule(module);
		vertexShaderResource.setPath(GUI_VERT_SHADER);

		final var fragmentShaderResource = new ModuleResourceImpl();
		fragmentShaderResource.setModule(module);
		fragmentShaderResource.setPath(GUI_FRAG_SHADER);

		vertexShader = new ShaderImpl();
		vertexShader.setFile(vertexShaderResource);
		vertexShader.setStage(EShaderStage.VERTEX_BIT);

		fragmentShader = new ShaderImpl();
		fragmentShader.setFile(fragmentShaderResource);
		fragmentShader.setStage(EShaderStage.FRAGMENT_BIT);

		shaders = List.of(vertexShader, fragmentShader);

		final var indexBufferAdapter = NuklearVertexBufferAdapter.adapt(nkPipeline.getIndexBuffer());
		indexBufferAdapter.setNullTexture(nullTexture);
	}

	public void allocate()
	{
		final var font = nkPipeline.getFont();
		final var fontAdapter = FontAdapter.adapt(font);

		fontLoader = new NkFontLoader(font);
		fontLoader.allocate();
		defaultFont = fontLoader.createNkFont(fontAdapter.getSamplerAddress());
	}

	public void free()
	{
		fontLoader.free();

		Objects.requireNonNull(defaultFont.query()).free();
		Objects.requireNonNull(defaultFont.width()).free();
	}

	public NkUserFont getDefaultFont()
	{
		return defaultFont;
	}

	public List<Object> toList()
	{
		if (resourceList == null)
		{
			final var font = nkPipeline.getFont();
			final var fontAdapter = FontAdapter.adapt(font);
			final var indexBufferAdapter = NuklearVertexBufferAdapter.adapt(nkPipeline.getIndexBuffer());
			final var vertShaderAdapter = ShaderAdapter.adapt(vertexShader);
			final var fragmentShaderAdapter = ShaderAdapter.adapt(fragmentShader);

			resourceList = List.of(nullTexture, fontAdapter, vertShaderAdapter,
					fragmentShaderAdapter, indexBufferAdapter);
		}

		return resourceList;
	}

	public List<IVkDescriptorSet> getDescriptorSets()
	{
		return descriptors;
	}

	public List<Shader> getShaders()
	{
		return shaders;
	}

	public Integer getDescriptorSetIndex(long textureId)
	{
		Integer res = null;

		if (textureId == nullTexture.getSamplerAddress())
		{
			res = 0;
		}
		else if (textureId == defaultFont.texture().ptr())
		{
			res = 1;
		}
		else
		{
			System.err.println("Invalid descriptor");
		}

		return res;
	}

}
