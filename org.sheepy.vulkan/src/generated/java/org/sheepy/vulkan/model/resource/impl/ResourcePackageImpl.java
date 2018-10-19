/**
 */
package org.sheepy.vulkan.model.resource.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.vulkan.model.enumeration.EnumerationPackage;

import org.sheepy.vulkan.model.resource.Buffer;
import org.sheepy.vulkan.model.resource.DepthImage;
import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.model.resource.FileResource;
import org.sheepy.vulkan.model.resource.IDescriptor;
import org.sheepy.vulkan.model.resource.Image;
import org.sheepy.vulkan.model.resource.IndexedBuffer;
import org.sheepy.vulkan.model.resource.MeshBuffer;
import org.sheepy.vulkan.model.resource.ModuleResource;
import org.sheepy.vulkan.model.resource.PathResource;
import org.sheepy.vulkan.model.resource.PushConstant;
import org.sheepy.vulkan.model.resource.Resource;
import org.sheepy.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.resource.Shader;
import org.sheepy.vulkan.model.resource.SizedBuffer;
import org.sheepy.vulkan.model.resource.Texture;
import org.sheepy.vulkan.model.resource.UniformBuffer;
import org.sheepy.vulkan.model.resource.VulkanBuffer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourcePackageImpl extends EPackageImpl implements ResourcePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vulkanBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sizedBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass depthImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pushConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptorSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexedBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass meshBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uniformBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType javaModuleEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ResourcePackageImpl()
	{
		super(eNS_URI, ResourceFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ResourcePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ResourcePackage init()
	{
		if (isInited) return (ResourcePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredResourcePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ResourcePackageImpl theResourcePackage = registeredResourcePackage instanceof ResourcePackageImpl ? (ResourcePackageImpl)registeredResourcePackage : new ResourcePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theResourcePackage.createPackageContents();

		// Initialize created meta-data
		theResourcePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theResourcePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ResourcePackage.eNS_URI, theResourcePackage);
		return theResourcePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource()
	{
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVulkanBuffer()
	{
		return vulkanBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuffer()
	{
		return bufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBuffer_Size()
	{
		return (EAttribute)bufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBuffer_Usage()
	{
		return (EAttribute)bufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBuffer_Properties()
	{
		return (EAttribute)bufferEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSizedBuffer()
	{
		return sizedBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImage()
	{
		return imageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTexture()
	{
		return textureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTexture_File()
	{
		return (EReference)textureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTexture_MipmapEnabled()
	{
		return (EAttribute)textureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDepthImage()
	{
		return depthImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathResource()
	{
		return pathResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPathResource_Path()
	{
		return (EAttribute)pathResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileResource()
	{
		return fileResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleResource()
	{
		return moduleResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModuleResource_Module()
	{
		return (EAttribute)moduleResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShader()
	{
		return shaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShader_File()
	{
		return (EReference)shaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShader_Stage()
	{
		return (EAttribute)shaderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPushConstant()
	{
		return pushConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPushConstant_Size()
	{
		return (EAttribute)pushConstantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPushConstant_Stage()
	{
		return (EAttribute)pushConstantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIDescriptor()
	{
		return iDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptorSet()
	{
		return descriptorSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptorSet_Descriptors()
	{
		return (EReference)descriptorSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexedBuffer()
	{
		return indexedBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeshBuffer()
	{
		return meshBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeshBuffer_Texture()
	{
		return (EReference)meshBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUniformBuffer()
	{
		return uniformBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJavaModule()
	{
		return javaModuleEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceFactory getResourceFactory()
	{
		return (ResourceFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		resourceEClass = createEClass(RESOURCE);

		vulkanBufferEClass = createEClass(VULKAN_BUFFER);

		bufferEClass = createEClass(BUFFER);
		createEAttribute(bufferEClass, BUFFER__SIZE);
		createEAttribute(bufferEClass, BUFFER__USAGE);
		createEAttribute(bufferEClass, BUFFER__PROPERTIES);

		sizedBufferEClass = createEClass(SIZED_BUFFER);

		imageEClass = createEClass(IMAGE);

		textureEClass = createEClass(TEXTURE);
		createEReference(textureEClass, TEXTURE__FILE);
		createEAttribute(textureEClass, TEXTURE__MIPMAP_ENABLED);

		depthImageEClass = createEClass(DEPTH_IMAGE);

		pathResourceEClass = createEClass(PATH_RESOURCE);
		createEAttribute(pathResourceEClass, PATH_RESOURCE__PATH);

		fileResourceEClass = createEClass(FILE_RESOURCE);

		moduleResourceEClass = createEClass(MODULE_RESOURCE);
		createEAttribute(moduleResourceEClass, MODULE_RESOURCE__MODULE);

		shaderEClass = createEClass(SHADER);
		createEReference(shaderEClass, SHADER__FILE);
		createEAttribute(shaderEClass, SHADER__STAGE);

		pushConstantEClass = createEClass(PUSH_CONSTANT);
		createEAttribute(pushConstantEClass, PUSH_CONSTANT__SIZE);
		createEAttribute(pushConstantEClass, PUSH_CONSTANT__STAGE);

		iDescriptorEClass = createEClass(IDESCRIPTOR);

		descriptorSetEClass = createEClass(DESCRIPTOR_SET);
		createEReference(descriptorSetEClass, DESCRIPTOR_SET__DESCRIPTORS);

		indexedBufferEClass = createEClass(INDEXED_BUFFER);

		meshBufferEClass = createEClass(MESH_BUFFER);
		createEReference(meshBufferEClass, MESH_BUFFER__TEXTURE);

		uniformBufferEClass = createEClass(UNIFORM_BUFFER);

		// Create data types
		javaModuleEDataType = createEDataType(JAVA_MODULE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		EnumerationPackage theEnumerationPackage = (EnumerationPackage)EPackage.Registry.INSTANCE.getEPackage(EnumerationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		vulkanBufferEClass.getESuperTypes().add(this.getResource());
		bufferEClass.getESuperTypes().add(this.getVulkanBuffer());
		sizedBufferEClass.getESuperTypes().add(this.getVulkanBuffer());
		imageEClass.getESuperTypes().add(this.getSizedBuffer());
		textureEClass.getESuperTypes().add(this.getVulkanBuffer());
		textureEClass.getESuperTypes().add(this.getIDescriptor());
		depthImageEClass.getESuperTypes().add(this.getVulkanBuffer());
		pathResourceEClass.getESuperTypes().add(this.getResource());
		fileResourceEClass.getESuperTypes().add(this.getPathResource());
		moduleResourceEClass.getESuperTypes().add(this.getPathResource());
		shaderEClass.getESuperTypes().add(this.getResource());
		pushConstantEClass.getESuperTypes().add(this.getVulkanBuffer());
		indexedBufferEClass.getESuperTypes().add(this.getVulkanBuffer());
		indexedBufferEClass.getESuperTypes().add(this.getIDescriptor());
		meshBufferEClass.getESuperTypes().add(this.getIndexedBuffer());
		uniformBufferEClass.getESuperTypes().add(this.getVulkanBuffer());
		uniformBufferEClass.getESuperTypes().add(this.getIDescriptor());

		// Initialize classes, features, and operations; add parameters
		initEClass(resourceEClass, Resource.class, "Resource", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vulkanBufferEClass, VulkanBuffer.class, "VulkanBuffer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bufferEClass, Buffer.class, "Buffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBuffer_Size(), theEcorePackage.getELong(), "size", null, 0, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuffer_Usage(), theEcorePackage.getEInt(), "usage", null, 0, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuffer_Properties(), theEcorePackage.getEInt(), "properties", null, 0, 1, Buffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sizedBufferEClass, SizedBuffer.class, "SizedBuffer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(imageEClass, Image.class, "Image", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(textureEClass, Texture.class, "Texture", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTexture_File(), this.getPathResource(), null, "file", null, 0, 1, Texture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTexture_MipmapEnabled(), theEcorePackage.getEBoolean(), "mipmapEnabled", "false", 0, 1, Texture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(depthImageEClass, DepthImage.class, "DepthImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pathResourceEClass, PathResource.class, "PathResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPathResource_Path(), theEcorePackage.getEString(), "path", null, 0, 1, PathResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileResourceEClass, FileResource.class, "FileResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moduleResourceEClass, ModuleResource.class, "ModuleResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModuleResource_Module(), this.getJavaModule(), "module", null, 0, 1, ModuleResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(shaderEClass, Shader.class, "Shader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getShader_File(), this.getPathResource(), null, "file", null, 0, 1, Shader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getShader_Stage(), theEnumerationPackage.getEShaderStage(), "stage", null, 0, 1, Shader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pushConstantEClass, PushConstant.class, "PushConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPushConstant_Size(), theEcorePackage.getEInt(), "size", null, 0, 1, PushConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPushConstant_Stage(), theEnumerationPackage.getEPipelineStage(), "stage", null, 0, 1, PushConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iDescriptorEClass, IDescriptor.class, "IDescriptor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(descriptorSetEClass, DescriptorSet.class, "DescriptorSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptorSet_Descriptors(), this.getIDescriptor(), null, "descriptors", null, 1, -1, DescriptorSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indexedBufferEClass, IndexedBuffer.class, "IndexedBuffer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(meshBufferEClass, MeshBuffer.class, "MeshBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeshBuffer_Texture(), this.getTexture(), null, "texture", null, 0, 1, MeshBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uniformBufferEClass, UniformBuffer.class, "UniformBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(javaModuleEDataType, Module.class, "JavaModule", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ResourcePackageImpl
