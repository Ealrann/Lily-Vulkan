/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Composite Buffer Flush Mode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.SetCompositeBufferFlushMode#getCompositeBuffer <em>Composite Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.SetCompositeBufferFlushMode#getMode <em>Mode</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getSetCompositeBufferFlushMode()
 * @model
 * @generated
 */
public interface SetCompositeBufferFlushMode extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Composite Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Buffer</em>' reference.
	 * @see #setCompositeBuffer(CompositeBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getSetCompositeBufferFlushMode_CompositeBuffer()
	 * @model required="true"
	 * @generated
	 */
	CompositeBuffer getCompositeBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.SetCompositeBufferFlushMode#getCompositeBuffer <em>Composite Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Buffer</em>' reference.
	 * @see #getCompositeBuffer()
	 * @generated
	 */
	void setCompositeBuffer(CompositeBuffer value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The default value is <code>"PUSH"</code>.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.resource.EFlushMode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.resource.EFlushMode
	 * @see #setMode(EFlushMode)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getSetCompositeBufferFlushMode_Mode()
	 * @model default="PUSH" required="true"
	 * @generated
	 */
	EFlushMode getMode();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.SetCompositeBufferFlushMode#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.resource.EFlushMode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(EFlushMode value);

} // SetCompositeBufferFlushMode
