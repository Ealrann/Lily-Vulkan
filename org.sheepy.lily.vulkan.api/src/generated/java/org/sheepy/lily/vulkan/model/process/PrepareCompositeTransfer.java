/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.CompositePartReference;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prepare Composite Transfer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getCompositeBuffer <em>Composite Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getMode <em>Mode</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#isPrepareDuringUpdate <em>Prepare During Update</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPrepareCompositeTransfer()
 * @model
 * @generated
 */
public interface PrepareCompositeTransfer extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Composite Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Buffer</em>' reference.
	 * @see #setCompositeBuffer(CompositeBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPrepareCompositeTransfer_CompositeBuffer()
	 * @model required="true"
	 * @generated
	 */
	CompositeBuffer getCompositeBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getCompositeBuffer <em>Composite Buffer</em>}' reference.
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
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPrepareCompositeTransfer_Mode()
	 * @model default="PUSH" required="true"
	 * @generated
	 */
	EFlushMode getMode();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.resource.EFlushMode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(EFlushMode value);

	/**
	 * Returns the value of the '<em><b>Prepare During Update</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prepare During Update</em>' attribute.
	 * @see #setPrepareDuringUpdate(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPrepareCompositeTransfer_PrepareDuringUpdate()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isPrepareDuringUpdate();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#isPrepareDuringUpdate <em>Prepare During Update</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prepare During Update</em>' attribute.
	 * @see #isPrepareDuringUpdate()
	 * @generated
	 */
	void setPrepareDuringUpdate(boolean value);

	/**
	 * Returns the value of the '<em><b>Stage</b></em>' attribute.
	 * The default value is <code>"Transfer"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.ECommandStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
	 * @see #setStage(ECommandStage)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPrepareCompositeTransfer_Stage()
	 * @model default="Transfer" required="true"
	 * @generated
	 */
	ECommandStage getStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getStage <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
	 * @see #getStage()
	 * @generated
	 */
	void setStage(ECommandStage value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.CompositePartReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPrepareCompositeTransfer_Parts()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<CompositePartReference> getParts();

} // PrepareCompositeTransfer
