/**
 */
package org.sheepy.vulkan.model.resource.impl;

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
			case ResourcePackage.TEXTURE: return createTexture();
			case ResourcePackage.DEPTH_IMAGE: return createDepthImage();
			case ResourcePackage.FILE_RESOURCE: return createFileResource();
			case ResourcePackage.MODULE_RESOURCE: return createModuleResource();
			case ResourcePackage.SHADER: return createShader();
			case ResourcePackage.PUSH_CONSTANT: return createPushConstant();
			case ResourcePackage.DESCRIPTOR_SET: return createDescriptorSet();
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
