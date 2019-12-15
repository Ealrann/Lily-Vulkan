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
public class ResourceFactoryImpl extends EFactoryImpl implements ResourceFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResourceFactory init()
	{
		try
		{
			ResourceFactory theResourceFactory = (ResourceFactory)EPackage.Registry.INSTANCE.getEFactory(ResourcePackage.eNS_URI);
			if (theResourceFactory != null)
			{
				return theResourceFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ResourceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceFactoryImpl()
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
			case ResourcePackage.TRANSFER_BUFFER: return createTransferBuffer();
			case ResourcePackage.CONSTANT_BUFFER: return createConstantBuffer();
			case ResourcePackage.BUFFER: return createBuffer();
			case ResourcePackage.COMPOSITE_BUFFER: return createCompositeBuffer();
			case ResourcePackage.COMPOSITE_PART_REFERENCE: return createCompositePartReference();
			case ResourcePackage.BUFFER_REFERENCE: return createBufferReference();
			case ResourcePackage.COMPOSITE_BUFFER_REFERENCE: return createCompositeBufferReference();
			case ResourcePackage.BUFFER_DATA_PROVIDER: return createBufferDataProvider();
			case ResourcePackage.STATIC_IMAGE: return createStaticImage();
			case ResourcePackage.FILE_IMAGE: return createFileImage();
			case ResourcePackage.SAMPLED_IMAGE: return createSampledImage();
			case ResourcePackage.SAMPLER: return createSampler();
			case ResourcePackage.SEMAPHORE: return createSemaphore();
			case ResourcePackage.FONT_IMAGE: return createFontImage();
			case ResourcePackage.BUFFER_DESCRIPTOR: return createBufferDescriptor();
			case ResourcePackage.IMAGE_DESCRIPTOR: return createImageDescriptor();
			case ResourcePackage.SAMPLED_IMAGE_DESCRIPTOR: return createSampledImageDescriptor();
			case ResourcePackage.SAMPLER_DESCRIPTOR: return createSamplerDescriptor();
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR: return createTexture2DArrayDescriptor();
			case ResourcePackage.DESCRIPTOR_SET: return createDescriptorSet();
			case ResourcePackage.DESCRIPTOR_SET_PKG: return createDescriptorSetPkg();
			case ResourcePackage.BUFFER_BARRIER: return createBufferBarrier();
			case ResourcePackage.COMPOSITE_BUFFER_BARRIER: return createCompositeBufferBarrier();
			case ResourcePackage.IMAGE_BARRIER: return createImageBarrier();
			case ResourcePackage.SHADER: return createShader();
			case ResourcePackage.FILE_RESOURCE: return createFileResource();
			case ResourcePackage.MODULE_RESOURCE: return createModuleResource();
			case ResourcePackage.STRING_MODULE_RESOURCE: return createStringModuleResource();
			case ResourcePackage.TEXTURE2_DARRAY: return createTexture2DArray();
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
			case ResourcePackage.EFLUSH_MODE:
				return createEFlushModeFromString(eDataType, initialValue);
			case ResourcePackage.BYTE_BUFFER:
				return createByteBufferFromString(eDataType, initialValue);
			case ResourcePackage.JAVA_MODULE:
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
			case ResourcePackage.EFLUSH_MODE:
				return convertEFlushModeToString(eDataType, instanceValue);
			case ResourcePackage.BYTE_BUFFER:
				return convertByteBufferToString(eDataType, instanceValue);
			case ResourcePackage.JAVA_MODULE:
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
	public CompositePartReference createCompositePartReference()
	{
		CompositePartReferenceImpl compositePartReference = new CompositePartReferenceImpl();
		return compositePartReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BufferReference createBufferReference()
	{
		BufferReferenceImpl bufferReference = new BufferReferenceImpl();
		return bufferReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeBufferReference createCompositeBufferReference()
	{
		CompositeBufferReferenceImpl compositeBufferReference = new CompositeBufferReferenceImpl();
		return compositeBufferReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T> BufferDataProvider<T> createBufferDataProvider()
	{
		BufferDataProviderImpl<T> bufferDataProvider = new BufferDataProviderImpl<T>();
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
	public Texture2DArrayDescriptor createTexture2DArrayDescriptor()
	{
		Texture2DArrayDescriptorImpl texture2DArrayDescriptor = new Texture2DArrayDescriptorImpl();
		return texture2DArrayDescriptor;
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
	public CompositeBufferBarrier createCompositeBufferBarrier()
	{
		CompositeBufferBarrierImpl compositeBufferBarrier = new CompositeBufferBarrierImpl();
		return compositeBufferBarrier;
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
	@Override
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
	@Override
	public StringModuleResource createStringModuleResource()
	{
		StringModuleResourceImpl stringModuleResource = new StringModuleResourceImpl();
		return stringModuleResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Texture2DArray createTexture2DArray()
	{
		Texture2DArrayImpl texture2DArray = new Texture2DArrayImpl();
		return texture2DArray;
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
	@Override
	public ResourcePackage getResourcePackage()
	{
		return (ResourcePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ResourcePackage getPackage()
	{
		return ResourcePackage.eINSTANCE;
	}

} //ResourceFactoryImpl
