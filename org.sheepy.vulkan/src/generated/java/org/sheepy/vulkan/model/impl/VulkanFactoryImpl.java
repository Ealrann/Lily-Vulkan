/**
 */
package org.sheepy.vulkan.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.vulkan.model.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VulkanFactoryImpl extends EFactoryImpl implements VulkanFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VulkanFactory init()
	{
		try
		{
			VulkanFactory theVulkanFactory = (VulkanFactory)EPackage.Registry.INSTANCE.getEFactory(VulkanPackage.eNS_URI);
			if (theVulkanFactory != null)
			{
				return theVulkanFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VulkanFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case VulkanPackage.VULKAN_APPLICATION: return createVulkanApplication();
			case VulkanPackage.GRAPHIC_CONFIGURATION: return createGraphicConfiguration();
			case VulkanPackage.RENDER_PASS_INFO: return createRenderPassInfo();
			case VulkanPackage.SUBPASS_DEPENDENCY: return createSubpassDependency();
			case VulkanPackage.ATTACHMENT_DESCRIPTION: return createAttachmentDescription();
			case VulkanPackage.COLOR_DOMAIN: return createColorDomain();
			case VulkanPackage.COMPUTE_PROCESS_POOL: return createComputeProcessPool();
			case VulkanPackage.GRAPHIC_PROCESS_POOL: return createGraphicProcessPool();
			case VulkanPackage.GRAPHIC_PROCESS: return createGraphicProcess();
			case VulkanPackage.COMPUTE_PROCESS: return createComputeProcess();
			case VulkanPackage.BUFFER_BARRIER: return createBufferBarrier();
			case VulkanPackage.IMAGE_BARRIER: return createImageBarrier();
			case VulkanPackage.REFERENCE_IMAGE_BARRIER: return createReferenceImageBarrier();
			case VulkanPackage.IMAGE_TRANSITION: return createImageTransition();
			case VulkanPackage.DESCRIPTOR_SET: return createDescriptorSet();
			case VulkanPackage.COMPUTE_PIPELINE: return createComputePipeline();
			case VulkanPackage.COMPUTER: return createComputer();
			case VulkanPackage.IMAGE_PIPELINE: return createImagePipeline();
			case VulkanPackage.MESH_PIPELINE: return createMeshPipeline();
			case VulkanPackage.BUFFER: return createBuffer();
			case VulkanPackage.TEXTURE: return createTexture();
			case VulkanPackage.DEPTH_IMAGE: return createDepthImage();
			case VulkanPackage.FILE_RESOURCE: return createFileResource();
			case VulkanPackage.MODULE_RESOURCE: return createModuleResource();
			case VulkanPackage.SHADER: return createShader();
			case VulkanPackage.PUSH_CONSTANT: return createPushConstant();
			case VulkanPackage.MESH_BUFFER: return createMeshBuffer();
			case VulkanPackage.UNIFORM_BUFFER: return createUniformBuffer();
			case VulkanPackage.BOARD_BUFFER: return createBoardBuffer();
			case VulkanPackage.BOARD_IMAGE: return createBoardImage();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
			case VulkanPackage.JAVA_MODULE:
				return createJavaModuleFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			case VulkanPackage.JAVA_MODULE:
				return convertJavaModuleToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanApplication createVulkanApplication()
	{
		VulkanApplicationImpl vulkanApplication = new VulkanApplicationImpl();
		return vulkanApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicConfiguration createGraphicConfiguration()
	{
		GraphicConfigurationImpl graphicConfiguration = new GraphicConfigurationImpl();
		return graphicConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RenderPassInfo createRenderPassInfo()
	{
		RenderPassInfoImpl renderPassInfo = new RenderPassInfoImpl();
		return renderPassInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubpassDependency createSubpassDependency()
	{
		SubpassDependencyImpl subpassDependency = new SubpassDependencyImpl();
		return subpassDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttachmentDescription createAttachmentDescription()
	{
		AttachmentDescriptionImpl attachmentDescription = new AttachmentDescriptionImpl();
		return attachmentDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorDomain createColorDomain()
	{
		ColorDomainImpl colorDomain = new ColorDomainImpl();
		return colorDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputeProcessPool createComputeProcessPool()
	{
		ComputeProcessPoolImpl computeProcessPool = new ComputeProcessPoolImpl();
		return computeProcessPool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicProcessPool createGraphicProcessPool()
	{
		GraphicProcessPoolImpl graphicProcessPool = new GraphicProcessPoolImpl();
		return graphicProcessPool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicProcess createGraphicProcess()
	{
		GraphicProcessImpl graphicProcess = new GraphicProcessImpl();
		return graphicProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputeProcess createComputeProcess()
	{
		ComputeProcessImpl computeProcess = new ComputeProcessImpl();
		return computeProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferBarrier createBufferBarrier()
	{
		BufferBarrierImpl bufferBarrier = new BufferBarrierImpl();
		return bufferBarrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageBarrier createImageBarrier()
	{
		ImageBarrierImpl imageBarrier = new ImageBarrierImpl();
		return imageBarrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceImageBarrier createReferenceImageBarrier()
	{
		ReferenceImageBarrierImpl referenceImageBarrier = new ReferenceImageBarrierImpl();
		return referenceImageBarrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageTransition createImageTransition()
	{
		ImageTransitionImpl imageTransition = new ImageTransitionImpl();
		return imageTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptorSet createDescriptorSet()
	{
		DescriptorSetImpl descriptorSet = new DescriptorSetImpl();
		return descriptorSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputePipeline createComputePipeline()
	{
		ComputePipelineImpl computePipeline = new ComputePipelineImpl();
		return computePipeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Computer createComputer()
	{
		ComputerImpl computer = new ComputerImpl();
		return computer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImagePipeline createImagePipeline()
	{
		ImagePipelineImpl imagePipeline = new ImagePipelineImpl();
		return imagePipeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeshPipeline createMeshPipeline()
	{
		MeshPipelineImpl meshPipeline = new MeshPipelineImpl();
		return meshPipeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Buffer createBuffer()
	{
		BufferImpl buffer = new BufferImpl();
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Texture createTexture()
	{
		TextureImpl texture = new TextureImpl();
		return texture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DepthImage createDepthImage()
	{
		DepthImageImpl depthImage = new DepthImageImpl();
		return depthImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileResource createFileResource()
	{
		FileResourceImpl fileResource = new FileResourceImpl();
		return fileResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleResource createModuleResource()
	{
		ModuleResourceImpl moduleResource = new ModuleResourceImpl();
		return moduleResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shader createShader()
	{
		ShaderImpl shader = new ShaderImpl();
		return shader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PushConstant createPushConstant()
	{
		PushConstantImpl pushConstant = new PushConstantImpl();
		return pushConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeshBuffer createMeshBuffer()
	{
		MeshBufferImpl meshBuffer = new MeshBufferImpl();
		return meshBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UniformBuffer createUniformBuffer()
	{
		UniformBufferImpl uniformBuffer = new UniformBufferImpl();
		return uniformBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoardBuffer createBoardBuffer()
	{
		BoardBufferImpl boardBuffer = new BoardBufferImpl();
		return boardBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoardImage createBoardImage()
	{
		BoardImageImpl boardImage = new BoardImageImpl();
		return boardImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module createJavaModuleFromString(EDataType eDataType, String initialValue)
	{
		return (Module)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJavaModuleToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanPackage getVulkanPackage()
	{
		return (VulkanPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VulkanPackage getPackage()
	{
		return VulkanPackage.eINSTANCE;
	}

} //VulkanFactoryImpl
