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
public class VulkanResourceSwitch<T1> extends Switch<T1>
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
		if (modelPackage == null)
		{
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
	protected T1 doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case VulkanResourcePackage.TRANSFER_BUFFER:
			{
				TransferBuffer transferBuffer = (TransferBuffer)theEObject;
				T1 result = caseTransferBuffer(transferBuffer);
				if (result == null) result = caseIResource(transferBuffer);
				if (result == null) result = caseLNamedElement(transferBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.CONSTANT_BUFFER:
			{
				ConstantBuffer constantBuffer = (ConstantBuffer)theEObject;
				T1 result = caseConstantBuffer(constantBuffer);
				if (result == null) result = caseIResource(constantBuffer);
				if (result == null) result = caseLNamedElement(constantBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.IBUFFER:
			{
				IBuffer iBuffer = (IBuffer)theEObject;
				T1 result = caseIBuffer(iBuffer);
				if (result == null) result = caseIResource(iBuffer);
				if (result == null) result = caseLNamedElement(iBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.BUFFER:
			{
				Buffer buffer = (Buffer)theEObject;
				T1 result = caseBuffer(buffer);
				if (result == null) result = caseIBuffer(buffer);
				if (result == null) result = caseIResource(buffer);
				if (result == null) result = caseLNamedElement(buffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.COMPOSITE_BUFFER:
			{
				CompositeBuffer compositeBuffer = (CompositeBuffer)theEObject;
				T1 result = caseCompositeBuffer(compositeBuffer);
				if (result == null) result = caseIResource(compositeBuffer);
				if (result == null) result = caseLNamedElement(compositeBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.BUFFER_PART:
			{
				BufferPart bufferPart = (BufferPart)theEObject;
				T1 result = caseBufferPart(bufferPart);
				if (result == null) result = caseIBuffer(bufferPart);
				if (result == null) result = caseIResource(bufferPart);
				if (result == null) result = caseLNamedElement(bufferPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER:
			{
				BufferDataProvider<?> bufferDataProvider = (BufferDataProvider<?>)theEObject;
				T1 result = caseBufferDataProvider(bufferDataProvider);
				if (result == null) result = caseLNamedElement(bufferDataProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.IMAGE:
			{
				Image image = (Image)theEObject;
				T1 result = caseImage(image);
				if (result == null) result = caseImageInfo(image);
				if (result == null) result = caseIImage(image);
				if (result == null) result = caseIResource(image);
				if (result == null) result = caseLNamedElement(image);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.STATIC_IMAGE:
			{
				StaticImage staticImage = (StaticImage)theEObject;
				T1 result = caseStaticImage(staticImage);
				if (result == null) result = caseImage(staticImage);
				if (result == null) result = caseImageInfo(staticImage);
				if (result == null) result = caseIImage(staticImage);
				if (result == null) result = caseIResource(staticImage);
				if (result == null) result = caseLNamedElement(staticImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.FILE_IMAGE:
			{
				FileImage fileImage = (FileImage)theEObject;
				T1 result = caseFileImage(fileImage);
				if (result == null) result = caseImage(fileImage);
				if (result == null) result = caseImageInfo(fileImage);
				if (result == null) result = caseIImage(fileImage);
				if (result == null) result = caseIResource(fileImage);
				if (result == null) result = caseLNamedElement(fileImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.FONT_IMAGE:
			{
				FontImage fontImage = (FontImage)theEObject;
				T1 result = caseFontImage(fontImage);
				if (result == null) result = caseImage(fontImage);
				if (result == null) result = caseImageInfo(fontImage);
				if (result == null) result = caseIImage(fontImage);
				if (result == null) result = caseIResource(fontImage);
				if (result == null) result = caseLNamedElement(fontImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.COMPOSITE_IMAGE:
			{
				CompositeImage compositeImage = (CompositeImage)theEObject;
				T1 result = caseCompositeImage(compositeImage);
				if (result == null) result = caseImage(compositeImage);
				if (result == null) result = caseImageInfo(compositeImage);
				if (result == null) result = caseIImage(compositeImage);
				if (result == null) result = caseIResource(compositeImage);
				if (result == null) result = caseLNamedElement(compositeImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.IMAGE_INLAY:
			{
				ImageInlay imageInlay = (ImageInlay)theEObject;
				T1 result = caseImageInlay(imageInlay);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.SAMPLED_IMAGE:
			{
				SampledImage sampledImage = (SampledImage)theEObject;
				T1 result = caseSampledImage(sampledImage);
				if (result == null) result = caseIResource(sampledImage);
				if (result == null) result = caseLNamedElement(sampledImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.SAMPLER:
			{
				Sampler sampler = (Sampler)theEObject;
				T1 result = caseSampler(sampler);
				if (result == null) result = caseSamplerInfo(sampler);
				if (result == null) result = caseIResource(sampler);
				if (result == null) result = caseLNamedElement(sampler);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.SEMAPHORE:
			{
				Semaphore semaphore = (Semaphore)theEObject;
				T1 result = caseSemaphore(semaphore);
				if (result == null) result = caseIResource(semaphore);
				if (result == null) result = caseLNamedElement(semaphore);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.BUFFER_DESCRIPTOR:
			{
				BufferDescriptor bufferDescriptor = (BufferDescriptor)theEObject;
				T1 result = caseBufferDescriptor(bufferDescriptor);
				if (result == null) result = caseIDescriptor(bufferDescriptor);
				if (result == null) result = caseLNamedElement(bufferDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.IMAGE_DESCRIPTOR:
			{
				ImageDescriptor imageDescriptor = (ImageDescriptor)theEObject;
				T1 result = caseImageDescriptor(imageDescriptor);
				if (result == null) result = caseIDescriptor(imageDescriptor);
				if (result == null) result = caseLNamedElement(imageDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.SAMPLED_IMAGE_DESCRIPTOR:
			{
				SampledImageDescriptor sampledImageDescriptor = (SampledImageDescriptor)theEObject;
				T1 result = caseSampledImageDescriptor(sampledImageDescriptor);
				if (result == null) result = caseIDescriptor(sampledImageDescriptor);
				if (result == null) result = caseLNamedElement(sampledImageDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.SAMPLER_DESCRIPTOR:
			{
				SamplerDescriptor samplerDescriptor = (SamplerDescriptor)theEObject;
				T1 result = caseSamplerDescriptor(samplerDescriptor);
				if (result == null) result = caseIDescriptor(samplerDescriptor);
				if (result == null) result = caseLNamedElement(samplerDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.DESCRIPTOR_SET:
			{
				DescriptorSet descriptorSet = (DescriptorSet)theEObject;
				T1 result = caseDescriptorSet(descriptorSet);
				if (result == null) result = caseLNamedElement(descriptorSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.DESCRIPTOR_SET_PKG:
			{
				DescriptorSetPkg descriptorSetPkg = (DescriptorSetPkg)theEObject;
				T1 result = caseDescriptorSetPkg(descriptorSetPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.BUFFER_BARRIER:
			{
				BufferBarrier bufferBarrier = (BufferBarrier)theEObject;
				T1 result = caseBufferBarrier(bufferBarrier);
				if (result == null) result = caseAbstractBufferBarrier(bufferBarrier);
				if (result == null) result = caseBarrier(bufferBarrier);
				if (result == null) result = caseLNamedElement(bufferBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.IMAGE_BARRIER:
			{
				ImageBarrier imageBarrier = (ImageBarrier)theEObject;
				T1 result = caseImageBarrier(imageBarrier);
				if (result == null) result = caseAbstractImageBarrier(imageBarrier);
				if (result == null) result = caseBarrier(imageBarrier);
				if (result == null) result = caseLNamedElement(imageBarrier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.SHADER:
			{
				Shader shader = (Shader)theEObject;
				T1 result = caseShader(shader);
				if (result == null) result = caseIResource(shader);
				if (result == null) result = caseLNamedElement(shader);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VulkanResourcePackage.IMAGE_ARRAY_DESCRIPTOR:
			{
				ImageArrayDescriptor imageArrayDescriptor = (ImageArrayDescriptor)theEObject;
				T1 result = caseImageArrayDescriptor(imageArrayDescriptor);
				if (result == null) result = caseIDescriptor(imageArrayDescriptor);
				if (result == null) result = caseLNamedElement(imageArrayDescriptor);
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
	public T1 caseTransferBuffer(TransferBuffer object)
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
	public T1 caseConstantBuffer(ConstantBuffer object)
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
	public T1 caseIBuffer(IBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBuffer(Buffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCompositeBuffer(CompositeBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBufferPart(BufferPart object)
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
	public <T> T1 caseBufferDataProvider(BufferDataProvider<T> object)
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
	public T1 caseImage(Image object)
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
	public T1 caseStaticImage(StaticImage object)
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
	public T1 caseFileImage(FileImage object)
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
	public T1 caseFontImage(FontImage object)
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
	public T1 caseCompositeImage(CompositeImage object)
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
	public T1 caseImageInlay(ImageInlay object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sampled Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sampled Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSampledImage(SampledImage object)
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
	public T1 caseSampler(Sampler object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semaphore</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semaphore</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSemaphore(Semaphore object)
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
	public T1 caseBufferDescriptor(BufferDescriptor object)
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
	public T1 caseImageDescriptor(ImageDescriptor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sampled Image Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sampled Image Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSampledImageDescriptor(SampledImageDescriptor object)
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
	public T1 caseSamplerDescriptor(SamplerDescriptor object)
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
	public T1 caseDescriptorSet(DescriptorSet object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descriptor Set Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptor Set Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDescriptorSetPkg(DescriptorSetPkg object)
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
	public T1 caseBufferBarrier(BufferBarrier object)
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
	public T1 caseImageBarrier(ImageBarrier object)
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
	public T1 caseShader(Shader object)
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
	public T1 caseImageArrayDescriptor(ImageArrayDescriptor object)
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
	public T1 caseLNamedElement(LNamedElement object)
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
	public T1 caseIResource(IResource object)
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
	public T1 caseImageInfo(ImageInfo object)
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
	public T1 caseIImage(IImage object)
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
	public T1 caseSamplerInfo(SamplerInfo object)
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
	public T1 caseIDescriptor(IDescriptor object)
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
	public T1 caseBarrier(Barrier object)
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
	public T1 caseAbstractBufferBarrier(AbstractBufferBarrier object)
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
	public T1 caseAbstractImageBarrier(AbstractImageBarrier object)
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
	public T1 defaultCase(EObject object)
	{
		return null;
	}

} //VulkanResourceSwitch
