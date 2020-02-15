/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.nio.ByteBuffer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.vulkan.model.resource.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VulkanResourceFactoryImpl extends EFactoryImpl implements VulkanResourceFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VulkanResourceFactory init()
	{
		try
		{
			VulkanResourceFactory theVulkanResourceFactory = (VulkanResourceFactory)EPackage.Registry.INSTANCE.getEFactory(VulkanResourcePackage.eNS_URI);
			if (theVulkanResourceFactory != null)
			{
				return theVulkanResourceFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VulkanResourceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanResourceFactoryImpl()
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
			case VulkanResourcePackage.TRANSFER_BUFFER: return createTransferBuffer();
			case VulkanResourcePackage.CONSTANT_BUFFER: return createConstantBuffer();
			case VulkanResourcePackage.GENERIC_CONSTANT_BUFFER: return createGenericConstantBuffer();
			case VulkanResourcePackage.BUFFER: return createBuffer();
			case VulkanResourcePackage.COMPOSITE_BUFFER: return createCompositeBuffer();
			case VulkanResourcePackage.BUFFER_PART: return createBufferPart();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER: return createBufferDataProvider();
			case VulkanResourcePackage.STATIC_IMAGE: return createStaticImage();
			case VulkanResourcePackage.FILE_IMAGE: return createFileImage();
			case VulkanResourcePackage.FONT_IMAGE: return createFontImage();
			case VulkanResourcePackage.COMPOSITE_IMAGE: return createCompositeImage();
			case VulkanResourcePackage.IMAGE_INLAY: return createImageInlay();
			case VulkanResourcePackage.SAMPLED_IMAGE: return createSampledImage();
			case VulkanResourcePackage.SAMPLER: return createSampler();
			case VulkanResourcePackage.SEMAPHORE: return createSemaphore();
			case VulkanResourcePackage.BUFFER_DESCRIPTOR: return createBufferDescriptor();
			case VulkanResourcePackage.IMAGE_DESCRIPTOR: return createImageDescriptor();
			case VulkanResourcePackage.SAMPLED_IMAGE_DESCRIPTOR: return createSampledImageDescriptor();
			case VulkanResourcePackage.SAMPLER_DESCRIPTOR: return createSamplerDescriptor();
			case VulkanResourcePackage.DESCRIPTOR_SET: return createDescriptorSet();
			case VulkanResourcePackage.DESCRIPTOR_SET_PKG: return createDescriptorSetPkg();
			case VulkanResourcePackage.BUFFER_BARRIER: return createBufferBarrier();
			case VulkanResourcePackage.IMAGE_BARRIER: return createImageBarrier();
			case VulkanResourcePackage.SHADER: return createShader();
			case VulkanResourcePackage.IMAGE_ARRAY_DESCRIPTOR: return createImageArrayDescriptor();
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
			case VulkanResourcePackage.EFLUSH_MODE:
				return createEFlushModeFromString(eDataType, initialValue);
			case VulkanResourcePackage.BYTE_BUFFER:
				return createByteBufferFromString(eDataType, initialValue);
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
			case VulkanResourcePackage.EFLUSH_MODE:
				return convertEFlushModeToString(eDataType, instanceValue);
			case VulkanResourcePackage.BYTE_BUFFER:
				return convertByteBufferToString(eDataType, instanceValue);
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
	public TransferBuffer createTransferBuffer()
	{
		TransferBufferImpl transferBuffer = new TransferBufferImpl();
		return transferBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstantBuffer createConstantBuffer()
	{
		ConstantBufferImpl constantBuffer = new ConstantBufferImpl();
		return constantBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenericConstantBuffer createGenericConstantBuffer()
	{
		GenericConstantBufferImpl genericConstantBuffer = new GenericConstantBufferImpl();
		return genericConstantBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public CompositeBuffer createCompositeBuffer()
	{
		CompositeBufferImpl compositeBuffer = new CompositeBufferImpl();
		return compositeBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BufferPart createBufferPart()
	{
		BufferPartImpl bufferPart = new BufferPartImpl();
		return bufferPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BufferDataProvider createBufferDataProvider()
	{
		BufferDataProviderImpl bufferDataProvider = new BufferDataProviderImpl();
		return bufferDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StaticImage createStaticImage()
	{
		StaticImageImpl staticImage = new StaticImageImpl();
		return staticImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FileImage createFileImage()
	{
		FileImageImpl fileImage = new FileImageImpl();
		return fileImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FontImage createFontImage()
	{
		FontImageImpl fontImage = new FontImageImpl();
		return fontImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeImage createCompositeImage()
	{
		CompositeImageImpl compositeImage = new CompositeImageImpl();
		return compositeImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageInlay createImageInlay()
	{
		ImageInlayImpl imageInlay = new ImageInlayImpl();
		return imageInlay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SampledImage createSampledImage()
	{
		SampledImageImpl sampledImage = new SampledImageImpl();
		return sampledImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sampler createSampler()
	{
		SamplerImpl sampler = new SamplerImpl();
		return sampler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Semaphore createSemaphore()
	{
		SemaphoreImpl semaphore = new SemaphoreImpl();
		return semaphore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BufferDescriptor createBufferDescriptor()
	{
		BufferDescriptorImpl bufferDescriptor = new BufferDescriptorImpl();
		return bufferDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageDescriptor createImageDescriptor()
	{
		ImageDescriptorImpl imageDescriptor = new ImageDescriptorImpl();
		return imageDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SampledImageDescriptor createSampledImageDescriptor()
	{
		SampledImageDescriptorImpl sampledImageDescriptor = new SampledImageDescriptorImpl();
		return sampledImageDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SamplerDescriptor createSamplerDescriptor()
	{
		SamplerDescriptorImpl samplerDescriptor = new SamplerDescriptorImpl();
		return samplerDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public DescriptorSetPkg createDescriptorSetPkg()
	{
		DescriptorSetPkgImpl descriptorSetPkg = new DescriptorSetPkgImpl();
		return descriptorSetPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
	public ImageArrayDescriptor createImageArrayDescriptor()
	{
		ImageArrayDescriptorImpl imageArrayDescriptor = new ImageArrayDescriptorImpl();
		return imageArrayDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFlushMode createEFlushModeFromString(EDataType eDataType, String initialValue)
	{
		EFlushMode result = EFlushMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEFlushModeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ByteBuffer createByteBufferFromString(EDataType eDataType, String initialValue)
	{
		return (ByteBuffer)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertByteBufferToString(EDataType eDataType, Object instanceValue)
	{
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VulkanResourcePackage getVulkanResourcePackage()
	{
		return (VulkanResourcePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VulkanResourcePackage getPackage()
	{
		return VulkanResourcePackage.eINSTANCE;
	}

} //VulkanResourceFactoryImpl
