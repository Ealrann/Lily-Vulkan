/**
 */
package org.sheepy.lily.vulkan.model.resource.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.resource.IResource;

import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.model.IDescriptor;

import org.sheepy.lily.vulkan.model.resource.*;

import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.model.barrier.Barrier;

import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.model.image.SamplerInfo;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage
 * @generated
 */
public class VulkanResourceSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VulkanResourcePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanResourceSwitch()
	{
		if (modelPackage == null) {
			modelPackage = VulkanResourcePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID) {
			case VulkanResourcePackage.TRANSFER_BUFFER: {
				TransferBuffer transferBuffer = (TransferBuffer)theEObject;
				T result = caseTransferBuffer(transferBuffer);
				if (result == null) result = caseIResource(transferBuffer);
				if (result == null) result = caseLNamedElement(transferBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.DESCRIPTOR_POOL: {
				DescriptorPool descriptorPool = (DescriptorPool)theEObject;
				T result = caseDescriptorPool(descriptorPool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.CONSTANT_BUFFER: {
				ConstantBuffer constantBuffer = (ConstantBuffer)theEObject;
				T result = caseConstantBuffer(constantBuffer);
				if (result == null) result = caseIResource(constantBuffer);
				if (result == null) result = caseLNamedElement(constantBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.GENERIC_CONSTANT_BUFFER: {
				GenericConstantBuffer genericConstantBuffer = (GenericConstantBuffer)theEObject;
				T result = caseGenericConstantBuffer(genericConstantBuffer);
				if (result == null) result = caseConstantBuffer(genericConstantBuffer);
				if (result == null) result = caseIResource(genericConstantBuffer);
				if (result == null) result = caseLNamedElement(genericConstantBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.IBUFFER: {
				IBuffer iBuffer = (IBuffer)theEObject;
				T result = caseIBuffer(iBuffer);
				if (result == null) result = caseLNamedElement(iBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.BUFFER_REFERENCE: {
				BufferReference bufferReference = (BufferReference)theEObject;
				T result = caseBufferReference(bufferReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER: {
				BufferDataProvider bufferDataProvider = (BufferDataProvider)theEObject;
				T result = caseBufferDataProvider(bufferDataProvider);
				if (result == null) result = caseLNamedElement(bufferDataProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.IMAGE: {
				Image image = (Image)theEObject;
				T result = caseImage(image);
				if (result == null) result = caseImageInfo(image);
				if (result == null) result = caseIImage(image);
				if (result == null) result = caseIResource(image);
				if (result == null) result = caseLNamedElement(image);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.FILE_IMAGE: {
				FileImage fileImage = (FileImage)theEObject;
				T result = caseFileImage(fileImage);
				if (result == null) result = caseImage(fileImage);
				if (result == null) result = caseImageInfo(fileImage);
				if (result == null) result = caseIImage(fileImage);
				if (result == null) result = caseIResource(fileImage);
				if (result == null) result = caseLNamedElement(fileImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.FONT_IMAGE: {
				FontImage fontImage = (FontImage)theEObject;
				T result = caseFontImage(fontImage);
				if (result == null) result = caseImage(fontImage);
				if (result == null) result = caseImageInfo(fontImage);
				if (result == null) result = caseIImage(fontImage);
				if (result == null) result = caseIResource(fontImage);
				if (result == null) result = caseLNamedElement(fontImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.COMPOSITE_IMAGE: {
				CompositeImage compositeImage = (CompositeImage)theEObject;
				T result = caseCompositeImage(compositeImage);
				if (result == null) result = caseImage(compositeImage);
				if (result == null) result = caseImageInfo(compositeImage);
				if (result == null) result = caseIImage(compositeImage);
				if (result == null) result = caseIResource(compositeImage);
				if (result == null) result = caseLNamedElement(compositeImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.IMAGE_INLAY: {
				ImageInlay imageInlay = (ImageInlay)theEObject;
				T result = caseImageInlay(imageInlay);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.SAMPLER: {
				Sampler sampler = (Sampler)theEObject;
				T result = caseSampler(sampler);
				if (result == null) result = caseSamplerInfo(sampler);
				if (result == null) result = caseIResource(sampler);
				if (result == null) result = caseLNamedElement(sampler);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.BUFFER_DESCRIPTOR: {
				BufferDescriptor bufferDescriptor = (BufferDescriptor)theEObject;
				T result = caseBufferDescriptor(bufferDescriptor);
				if (result == null) result = caseIDescriptor(bufferDescriptor);
				if (result == null) result = caseLNamedElement(bufferDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.IMAGE_DESCRIPTOR: {
				ImageDescriptor imageDescriptor = (ImageDescriptor)theEObject;
				T result = caseImageDescriptor(imageDescriptor);
				if (result == null) result = caseIDescriptor(imageDescriptor);
				if (result == null) result = caseLNamedElement(imageDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.SAMPLER_DESCRIPTOR: {
				SamplerDescriptor samplerDescriptor = (SamplerDescriptor)theEObject;
				T result = caseSamplerDescriptor(samplerDescriptor);
				if (result == null) result = caseIDescriptor(samplerDescriptor);
				if (result == null) result = caseLNamedElement(samplerDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.DESCRIPTOR_SET: {
				DescriptorSet descriptorSet = (DescriptorSet)theEObject;
				T result = caseDescriptorSet(descriptorSet);
				if (result == null) result = caseLNamedElement(descriptorSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.BUFFER_BARRIER: {
				BufferBarrier bufferBarrier = (BufferBarrier)theEObject;
				T result = caseBufferBarrier(bufferBarrier);
				if (result == null) result = caseAbstractBufferBarrier(bufferBarrier);
				if (result == null) result = caseBarrier(bufferBarrier);
				if (result == null) result = caseLNamedElement(bufferBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.IMAGE_BARRIER: {
				ImageBarrier imageBarrier = (ImageBarrier)theEObject;
				T result = caseImageBarrier(imageBarrier);
				if (result == null) result = caseAbstractImageBarrier(imageBarrier);
				if (result == null) result = caseBarrier(imageBarrier);
				if (result == null) result = caseLNamedElement(imageBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.SHADER: {
				Shader shader = (Shader)theEObject;
				T result = caseShader(shader);
				if (result == null) result = caseIResource(shader);
				if (result == null) result = caseLNamedElement(shader);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.IMAGE_ARRAY_DESCRIPTOR: {
				ImageArrayDescriptor imageArrayDescriptor = (ImageArrayDescriptor)theEObject;
				T result = caseImageArrayDescriptor(imageArrayDescriptor);
				if (result == null) result = caseIDescriptor(imageArrayDescriptor);
				if (result == null) result = caseLNamedElement(imageArrayDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.MEMORY_CHUNK: {
				MemoryChunk memoryChunk = (MemoryChunk)theEObject;
				T result = caseMemoryChunk(memoryChunk);
				if (result == null) result = caseIResource(memoryChunk);
				if (result == null) result = caseLNamedElement(memoryChunk);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.IMEMORY_CHUNK_PART: {
				IMemoryChunkPart iMemoryChunkPart = (IMemoryChunkPart)theEObject;
				T result = caseIMemoryChunkPart(iMemoryChunkPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.BUFFER_MEMORY: {
				BufferMemory bufferMemory = (BufferMemory)theEObject;
				T result = caseBufferMemory(bufferMemory);
				if (result == null) result = caseIMemoryChunkPart(bufferMemory);
				if (result == null) result = caseLNamedElement(bufferMemory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.IBUFFER_OBJECT: {
				IBufferObject iBufferObject = (IBufferObject)theEObject;
				T result = caseIBufferObject(iBufferObject);
				if (result == null) result = caseIBuffer(iBufferObject);
				if (result == null) result = caseLNamedElement(iBufferObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.STATIC_BUFFER: {
				StaticBuffer staticBuffer = (StaticBuffer)theEObject;
				T result = caseStaticBuffer(staticBuffer);
				if (result == null) result = caseIBufferObject(staticBuffer);
				if (result == null) result = caseIBuffer(staticBuffer);
				if (result == null) result = caseLNamedElement(staticBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.DATA_BUFFER: {
				DataBuffer dataBuffer = (DataBuffer)theEObject;
				T result = caseDataBuffer(dataBuffer);
				if (result == null) result = caseIBufferObject(dataBuffer);
				if (result == null) result = caseIBuffer(dataBuffer);
				if (result == null) result = caseLNamedElement(dataBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.BUFFER_VIEWER: {
				BufferViewer bufferViewer = (BufferViewer)theEObject;
				T result = caseBufferViewer(bufferViewer);
				if (result == null) result = caseIBufferObject(bufferViewer);
				if (result == null) result = caseIBuffer(bufferViewer);
				if (result == null) result = caseLNamedElement(bufferViewer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.STATIC_IMAGE: {
				StaticImage staticImage = (StaticImage)theEObject;
				T result = caseStaticImage(staticImage);
				if (result == null) result = caseIMemoryChunkPart(staticImage);
				if (result == null) result = caseImage(staticImage);
				if (result == null) result = caseImageInfo(staticImage);
				if (result == null) result = caseIImage(staticImage);
				if (result == null) result = caseIResource(staticImage);
				if (result == null) result = caseLNamedElement(staticImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transfer Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transfer Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransferBuffer(TransferBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descriptor Pool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptor Pool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptorPool(DescriptorPool object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constant Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constant Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstantBuffer(ConstantBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Constant Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Constant Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericConstantBuffer(GenericConstantBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IBuffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IBuffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIBuffer(IBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferReference(BufferReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Data Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferDataProvider(BufferDataProvider object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImage(Image object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStaticImage(StaticImage object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileImage(FileImage object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Font Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Font Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFontImage(FontImage object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeImage(CompositeImage object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Inlay</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Inlay</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageInlay(ImageInlay object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sampler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sampler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSampler(Sampler object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferDescriptor(BufferDescriptor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageDescriptor(ImageDescriptor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sampler Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sampler Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSamplerDescriptor(SamplerDescriptor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descriptor Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptor Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptorSet(DescriptorSet object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferBarrier(BufferBarrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageBarrier(ImageBarrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shader</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shader</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShader(Shader object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Array Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Array Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageArrayDescriptor(ImageArrayDescriptor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Chunk</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Chunk</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryChunk(MemoryChunk object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMemory Chunk Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMemory Chunk Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMemoryChunkPart(IMemoryChunkPart object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Memory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Memory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferMemory(BufferMemory object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IBuffer Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IBuffer Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIBufferObject(IBufferObject object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStaticBuffer(StaticBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataBuffer(DataBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Viewer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Viewer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferViewer(BufferViewer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LNamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LNamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLNamedElement(LNamedElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IResource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IResource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIResource(IResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageInfo(ImageInfo object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IImage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IImage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIImage(IImage object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sampler Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sampler Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSamplerInfo(SamplerInfo object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDescriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDescriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDescriptor(IDescriptor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBarrier(Barrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Buffer Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Buffer Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractBufferBarrier(AbstractBufferBarrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Image Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Image Barrier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractImageBarrier(AbstractImageBarrier object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object)
	{
		return null;
	}

} //VulkanResourceSwitch
