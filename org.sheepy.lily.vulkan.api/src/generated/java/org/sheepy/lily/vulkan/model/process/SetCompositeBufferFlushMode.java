/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.SetCompositeBufferFlushMode#getStage <em>Stage</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.ECommandStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
	 * @see #isSetStage()
	 * @see #unsetStage()
	 * @see #setStage(ECommandStage)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getSetCompositeBufferFlushMode_Stage()
	 * @model unsettable="true" required="true"
	 * @generated
	 */
	ECommandStage getStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.SetCompositeBufferFlushMode#getStage <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
	 * @see #isSetStage()
	 * @see #unsetStage()
	 * @see #getStage()
	 * @generated
	 */
	void setStage(ECommandStage value);

	/**
	 * Unsets the value of the '{@link org.sheepy.lily.vulkan.model.process.SetCompositeBufferFlushMode#getStage <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStage()
	 * @see #getStage()
	 * @see #setStage(ECommandStage)
	 * @generated
	 */
	void unsetStage();

	/**
	 * Returns whether the value of the '{@link org.sheepy.lily.vulkan.model.process.SetCompositeBufferFlushMode#getStage <em>Stage</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Stage</em>' attribute is set.
	 * @see #unsetStage()
	 * @see #getStage()
	 * @see #setStage(ECommandStage)
	 * @generated
	 */
	boolean isSetStage();

} // SetCompositeBufferFlushMode
