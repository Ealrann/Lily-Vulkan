/**
 */
package org.sheepy.lily.vulkan.model.resource.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.model.IResource;

import org.sheepy.lily.vulkan.model.resource.*;
import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.model.barrier.Barrier;

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
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage
 * @generated
 */
public class ResourceSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ResourcePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = ResourcePackage.eINSTANCE;
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
		switch (classifierID)
		{
		case ResourcePackage.BASIC_RESOURCE:
		{
			BasicResource basicResource = (BasicResource) theEObject;
			T result = caseBasicResource(basicResource);
			if (result == null) result = caseIResource(basicResource);
			if (result == null) result = caseLNamedElement(basicResource);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.PUSH_BUFFER:
		{
			PushBuffer pushBuffer = (PushBuffer) theEObject;
			T result = casePushBuffer(pushBuffer);
			if (result == null) result = caseIResource(pushBuffer);
			if (result == null) result = caseLNamedElement(pushBuffer);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.CONSTANT_BUFFER:
		{
			ConstantBuffer constantBuffer = (ConstantBuffer) theEObject;
			T result = caseConstantBuffer(constantBuffer);
			if (result == null) result = caseIResource(constantBuffer);
			if (result == null) result = caseLNamedElement(constantBuffer);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.DESCRIPTED_RESOURCE:
		{
			DescriptedResource descriptedResource = (DescriptedResource) theEObject;
			T result = caseDescriptedResource(descriptedResource);
			if (result == null) result = caseIResource(descriptedResource);
			if (result == null) result = caseLNamedElement(descriptedResource);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.BASIC_DESCRIPTED_RESOURCE:
		{
			BasicDescriptedResource basicDescriptedResource = (BasicDescriptedResource) theEObject;
			T result = caseBasicDescriptedResource(basicDescriptedResource);
			if (result == null) result = caseDescriptedResource(basicDescriptedResource);
			if (result == null) result = caseIResource(basicDescriptedResource);
			if (result == null) result = caseLNamedElement(basicDescriptedResource);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.IBUFFER:
		{
			IBuffer iBuffer = (IBuffer) theEObject;
			T result = caseIBuffer(iBuffer);
			if (result == null) result = caseIResource(iBuffer);
			if (result == null) result = caseLNamedElement(iBuffer);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.BUFFER:
		{
			Buffer buffer = (Buffer) theEObject;
			T result = caseBuffer(buffer);
			if (result == null) result = caseBasicDescriptedResource(buffer);
			if (result == null) result = caseIBuffer(buffer);
			if (result == null) result = caseDescriptedResource(buffer);
			if (result == null) result = caseIResource(buffer);
			if (result == null) result = caseLNamedElement(buffer);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.COMPOSITE_BUFFER:
		{
			CompositeBuffer compositeBuffer = (CompositeBuffer) theEObject;
			T result = caseCompositeBuffer(compositeBuffer);
			if (result == null) result = caseDescriptedResource(compositeBuffer);
			if (result == null) result = caseIBuffer(compositeBuffer);
			if (result == null) result = caseIResource(compositeBuffer);
			if (result == null) result = caseLNamedElement(compositeBuffer);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.IBUFFER_REFERENCE:
		{
			IBufferReference iBufferReference = (IBufferReference) theEObject;
			T result = caseIBufferReference(iBufferReference);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.BUFFER_REFERENCE:
		{
			BufferReference bufferReference = (BufferReference) theEObject;
			T result = caseBufferReference(bufferReference);
			if (result == null) result = caseIBufferReference(bufferReference);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.COMPOSITE_BUFFER_REFERENCE:
		{
			CompositeBufferReference compositeBufferReference = (CompositeBufferReference) theEObject;
			T result = caseCompositeBufferReference(compositeBufferReference);
			if (result == null) result = caseIBufferReference(compositeBufferReference);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.BUFFER_DATA_PROVIDER:
		{
			BufferDataProvider bufferDataProvider = (BufferDataProvider) theEObject;
			T result = caseBufferDataProvider(bufferDataProvider);
			if (result == null) result = caseLNamedElement(bufferDataProvider);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.DESCRIBED_DATA_PROVIDER:
		{
			DescribedDataProvider describedDataProvider = (DescribedDataProvider) theEObject;
			T result = caseDescribedDataProvider(describedDataProvider);
			if (result == null) result = caseBufferDataProvider(describedDataProvider);
			if (result == null) result = caseDescriptor(describedDataProvider);
			if (result == null) result = caseLNamedElement(describedDataProvider);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.IMAGE:
		{
			Image image = (Image) theEObject;
			T result = caseImage(image);
			if (result == null) result = caseBasicDescriptedResource(image);
			if (result == null) result = caseDescriptedResource(image);
			if (result == null) result = caseIResource(image);
			if (result == null) result = caseLNamedElement(image);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.IMAGE_LAYOUT:
		{
			ImageLayout imageLayout = (ImageLayout) theEObject;
			T result = caseImageLayout(imageLayout);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.SAMPLED_IMAGE:
		{
			SampledImage sampledImage = (SampledImage) theEObject;
			T result = caseSampledImage(sampledImage);
			if (result == null) result = caseBasicDescriptedResource(sampledImage);
			if (result == null) result = caseDescriptedResource(sampledImage);
			if (result == null) result = caseIResource(sampledImage);
			if (result == null) result = caseLNamedElement(sampledImage);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.SEMAPHORE:
		{
			Semaphore semaphore = (Semaphore) theEObject;
			T result = caseSemaphore(semaphore);
			if (result == null) result = caseBasicResource(semaphore);
			if (result == null) result = caseIResource(semaphore);
			if (result == null) result = caseLNamedElement(semaphore);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.FONT:
		{
			Font font = (Font) theEObject;
			T result = caseFont(font);
			if (result == null) result = caseSampledImage(font);
			if (result == null) result = caseBasicDescriptedResource(font);
			if (result == null) result = caseDescriptedResource(font);
			if (result == null) result = caseIResource(font);
			if (result == null) result = caseLNamedElement(font);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.ABSTRACT_TEXTURE:
		{
			AbstractTexture abstractTexture = (AbstractTexture) theEObject;
			T result = caseAbstractTexture(abstractTexture);
			if (result == null) result = caseSampledImage(abstractTexture);
			if (result == null) result = caseBasicDescriptedResource(abstractTexture);
			if (result == null) result = caseDescriptedResource(abstractTexture);
			if (result == null) result = caseIResource(abstractTexture);
			if (result == null) result = caseLNamedElement(abstractTexture);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.TEXTURE:
		{
			Texture texture = (Texture) theEObject;
			T result = caseTexture(texture);
			if (result == null) result = caseAbstractTexture(texture);
			if (result == null) result = caseSampledImage(texture);
			if (result == null) result = caseBasicDescriptedResource(texture);
			if (result == null) result = caseDescriptedResource(texture);
			if (result == null) result = caseIResource(texture);
			if (result == null) result = caseLNamedElement(texture);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.SAMPLER:
		{
			Sampler sampler = (Sampler) theEObject;
			T result = caseSampler(sampler);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.DESCRIPTOR:
		{
			Descriptor descriptor = (Descriptor) theEObject;
			T result = caseDescriptor(descriptor);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.DESCRIPTOR_SET:
		{
			DescriptorSet descriptorSet = (DescriptorSet) theEObject;
			T result = caseDescriptorSet(descriptorSet);
			if (result == null) result = caseLNamedElement(descriptorSet);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.DESCRIPTOR_SET_PKG:
		{
			DescriptorSetPkg descriptorSetPkg = (DescriptorSetPkg) theEObject;
			T result = caseDescriptorSetPkg(descriptorSetPkg);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.BUFFER_BARRIER:
		{
			BufferBarrier bufferBarrier = (BufferBarrier) theEObject;
			T result = caseBufferBarrier(bufferBarrier);
			if (result == null) result = caseAbstractBufferBarrier(bufferBarrier);
			if (result == null) result = caseBarrier(bufferBarrier);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.IMAGE_BARRIER:
		{
			ImageBarrier imageBarrier = (ImageBarrier) theEObject;
			T result = caseImageBarrier(imageBarrier);
			if (result == null) result = caseAbstractImageBarrier(imageBarrier);
			if (result == null) result = caseBarrier(imageBarrier);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.SHADER:
		{
			Shader shader = (Shader) theEObject;
			T result = caseShader(shader);
			if (result == null) result = caseBasicResource(shader);
			if (result == null) result = caseIResource(shader);
			if (result == null) result = caseLNamedElement(shader);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.PATH_RESOURCE:
		{
			PathResource pathResource = (PathResource) theEObject;
			T result = casePathResource(pathResource);
			if (result == null) result = caseBasicResource(pathResource);
			if (result == null) result = caseIResource(pathResource);
			if (result == null) result = caseLNamedElement(pathResource);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.FILE_RESOURCE:
		{
			FileResource fileResource = (FileResource) theEObject;
			T result = caseFileResource(fileResource);
			if (result == null) result = casePathResource(fileResource);
			if (result == null) result = caseBasicResource(fileResource);
			if (result == null) result = caseIResource(fileResource);
			if (result == null) result = caseLNamedElement(fileResource);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.ABSTRACT_MODULE_RESOURCE:
		{
			AbstractModuleResource abstractModuleResource = (AbstractModuleResource) theEObject;
			T result = caseAbstractModuleResource(abstractModuleResource);
			if (result == null) result = casePathResource(abstractModuleResource);
			if (result == null) result = caseBasicResource(abstractModuleResource);
			if (result == null) result = caseIResource(abstractModuleResource);
			if (result == null) result = caseLNamedElement(abstractModuleResource);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.MODULE_RESOURCE:
		{
			ModuleResource moduleResource = (ModuleResource) theEObject;
			T result = caseModuleResource(moduleResource);
			if (result == null) result = caseAbstractModuleResource(moduleResource);
			if (result == null) result = casePathResource(moduleResource);
			if (result == null) result = caseBasicResource(moduleResource);
			if (result == null) result = caseIResource(moduleResource);
			if (result == null) result = caseLNamedElement(moduleResource);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		case ResourcePackage.STRING_MODULE_RESOURCE:
		{
			StringModuleResource stringModuleResource = (StringModuleResource) theEObject;
			T result = caseStringModuleResource(stringModuleResource);
			if (result == null) result = caseAbstractModuleResource(stringModuleResource);
			if (result == null) result = casePathResource(stringModuleResource);
			if (result == null) result = caseBasicResource(stringModuleResource);
			if (result == null) result = caseIResource(stringModuleResource);
			if (result == null) result = caseLNamedElement(stringModuleResource);
			if (result == null) result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicResource(BasicResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descripted Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descripted Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptedResource(DescriptedResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Descripted Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Descripted Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicDescriptedResource(BasicDescriptedResource object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Push Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Push Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePushBuffer(PushBuffer object)
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
	public T caseBuffer(Buffer object)
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
	public T caseCompositeBuffer(CompositeBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IBuffer Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IBuffer Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIBufferReference(IBufferReference object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Composite Buffer Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Buffer Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeBufferReference(CompositeBufferReference object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Described Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Described Data Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescribedDataProvider(DescribedDataProvider object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Image Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageLayout(ImageLayout object)
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
	public T caseSampledImage(SampledImage object)
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
	public T caseSemaphore(Semaphore object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Font</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Font</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFont(Font object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Texture</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Texture</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTexture(AbstractTexture object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Texture</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Texture</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTexture(Texture object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptor(Descriptor object)
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
	public T caseDescriptorSetPkg(DescriptorSetPkg object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Path Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePathResource(PathResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileResource(FileResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Module Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Module Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractModuleResource(AbstractModuleResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleResource(ModuleResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Module Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Module Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringModuleResource(StringModuleResource object)
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

} //ResourceSwitch
