/**
 */
package org.sheepy.lily.vulkan.model.binding;

import org.sheepy.lily.vulkan.model.resource.BufferDescriptor;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configure Buffer Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor#getCompositeBuffer <em>Composite Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor#getPartIndex <em>Part Index</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor#getDescriptor <em>Descriptor</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureBufferDescriptor()
 * @model
 * @generated
 */
public interface ConfigureBufferDescriptor extends IConfigurationTask
{
	/**
	 * Returns the value of the '<em><b>Composite Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Buffer</em>' reference.
	 * @see #setCompositeBuffer(CompositeBuffer)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureBufferDescriptor_CompositeBuffer()
	 * @model required="true"
	 * @generated
	 */
	CompositeBuffer getCompositeBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor#getCompositeBuffer <em>Composite Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Buffer</em>' reference.
	 * @see #getCompositeBuffer()
	 * @generated
	 */
	void setCompositeBuffer(CompositeBuffer value);

	/**
	 * Returns the value of the '<em><b>Part Index</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.binding.EContextIndex}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Index</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.binding.EContextIndex
	 * @see #setPartIndex(EContextIndex)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureBufferDescriptor_PartIndex()
	 * @model required="true"
	 * @generated
	 */
	EContextIndex getPartIndex();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor#getPartIndex <em>Part Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Index</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.binding.EContextIndex
	 * @see #getPartIndex()
	 * @generated
	 */
	void setPartIndex(EContextIndex value);

	/**
	 * Returns the value of the '<em><b>Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor</em>' reference.
	 * @see #setDescriptor(BufferDescriptor)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureBufferDescriptor_Descriptor()
	 * @model required="true"
	 * @generated
	 */
	BufferDescriptor getDescriptor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor#getDescriptor <em>Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor</em>' reference.
	 * @see #getDescriptor()
	 * @generated
	 */
	void setDescriptor(BufferDescriptor value);

} // ConfigureBufferDescriptor
