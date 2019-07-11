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
			ResourceFactory theResourceFactory = (ResourceFactory) EPackage.Registry.INSTANCE
					.getEFactory(ResourcePackage.eNS_URI);
			if (theResourceFactory != null)
			{
				return theResourceFactory;
			}
		} catch (Exception exception)
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
		case ResourcePackage.BASIC_RESOURCE:
			return createBasicResource();
		case ResourcePackage.PUSH_BUFFER:
			return createPushBuffer();
		case ResourcePackage.GET_BUFFER:
			return createGetBuffer();
		case ResourcePackage.CONSTANT_BUFFER:
			return createConstantBuffer();
		case ResourcePackage.BUFFER:
			return createBuffer();
		case ResourcePackage.COMPOSITE_BUFFER:
			return createCompositeBuffer();
		case ResourcePackage.BUFFER_REFERENCE:
			return createBufferReference();
		case ResourcePackage.COMPOSITE_BUFFER_REFERENCE:
			return createCompositeBufferReference();
		case ResourcePackage.BUFFER_DATA_PROVIDER:
			return createBufferDataProvider();
		case ResourcePackage.DESCRIBED_DATA_PROVIDER:
			return createDescribedDataProvider();
		case ResourcePackage.IMAGE:
			return createImage();
		case ResourcePackage.IMAGE_LAYOUT:
			return createImageLayout();
		case ResourcePackage.SAMPLED_IMAGE:
			return createSampledImage();
		case ResourcePackage.SEMAPHORE:
			return createSemaphore();
		case ResourcePackage.FONT:
			return createFont();
		case ResourcePackage.TEXTURE:
			return createTexture();
		case ResourcePackage.SAMPLER:
			return createSampler();
		case ResourcePackage.DESCRIPTOR:
			return createDescriptor();
		case ResourcePackage.DESCRIPTOR_SET:
			return createDescriptorSet();
		case ResourcePackage.DESCRIPTOR_SET_PKG:
			return createDescriptorSetPkg();
		case ResourcePackage.BUFFER_BARRIER:
			return createBufferBarrier();
		case ResourcePackage.IMAGE_BARRIER:
			return createImageBarrier();
		case ResourcePackage.SHADER:
			return createShader();
		case ResourcePackage.FILE_RESOURCE:
			return createFileResource();
		case ResourcePackage.MODULE_RESOURCE:
			return createModuleResource();
		case ResourcePackage.STRING_MODULE_RESOURCE:
			return createStringModuleResource();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier");
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
		case ResourcePackage.BYTE_BUFFER:
			return createByteBufferFromString(eDataType, initialValue);
		case ResourcePackage.JAVA_MODULE:
			return createJavaModuleFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
		case ResourcePackage.BYTE_BUFFER:
			return convertByteBufferToString(eDataType, instanceValue);
		case ResourcePackage.JAVA_MODULE:
			return convertJavaModuleToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BasicResource createBasicResource()
	{
		BasicResourceImpl basicResource = new BasicResourceImpl();
		return basicResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PushBuffer createPushBuffer()
	{
		PushBufferImpl pushBuffer = new PushBufferImpl();
		return pushBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GetBuffer createGetBuffer()
	{
		GetBufferImpl getBuffer = new GetBufferImpl();
		return getBuffer;
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
	public DescribedDataProvider createDescribedDataProvider()
	{
		DescribedDataProviderImpl describedDataProvider = new DescribedDataProviderImpl();
		return describedDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Image createImage()
	{
		ImageImpl image = new ImageImpl();
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageLayout createImageLayout()
	{
		ImageLayoutImpl imageLayout = new ImageLayoutImpl();
		return imageLayout;
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
	public Font createFont()
	{
		FontImpl font = new FontImpl();
		return font;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	public Descriptor createDescriptor()
	{
		DescriptorImpl descriptor = new DescriptorImpl();
		return descriptor;
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
	public ByteBuffer createByteBufferFromString(EDataType eDataType, String initialValue)
	{
		return (ByteBuffer) super.createFromString(eDataType, initialValue);
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
		return (Module) super.createFromString(eDataType, initialValue);
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
		return (ResourcePackage) getEPackage();
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
