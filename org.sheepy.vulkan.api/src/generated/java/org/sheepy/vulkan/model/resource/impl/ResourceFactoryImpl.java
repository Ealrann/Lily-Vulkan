/**
 */
package org.sheepy.vulkan.model.resource.impl;

import java.nio.ByteBuffer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.vulkan.model.resource.*;

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
			case ResourcePackage.BUFFER: return createBuffer();
			case ResourcePackage.IMAGE: return createImage();
			case ResourcePackage.IMAGE_LAYOUT: return createImageLayout();
			case ResourcePackage.FONT: return createFont();
			case ResourcePackage.TEXTURE: return createTexture();
			case ResourcePackage.SAMPLER: return createSampler();
			case ResourcePackage.CONSTANTS: return createConstants();
			case ResourcePackage.BASIC_DESCRIPTOR_SET: return createBasicDescriptorSet();
			case ResourcePackage.BUFFER_BARRIER: return createBufferBarrier();
			case ResourcePackage.IMAGE_BARRIER: return createImageBarrier();
			case ResourcePackage.REFERENCE_IMAGE_BARRIER: return createReferenceImageBarrier();
			case ResourcePackage.IMAGE_TRANSITION: return createImageTransition();
			case ResourcePackage.SHADER: return createShader();
			case ResourcePackage.DEPTH_IMAGE: return createDepthImage();
			case ResourcePackage.FILE_RESOURCE: return createFileResource();
			case ResourcePackage.MODULE_RESOURCE: return createModuleResource();
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
	public Constants createConstants()
	{
		ConstantsImpl constants = new ConstantsImpl();
		return constants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BasicDescriptorSet createBasicDescriptorSet()
	{
		BasicDescriptorSetImpl basicDescriptorSet = new BasicDescriptorSetImpl();
		return basicDescriptorSet;
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
	@Override
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
