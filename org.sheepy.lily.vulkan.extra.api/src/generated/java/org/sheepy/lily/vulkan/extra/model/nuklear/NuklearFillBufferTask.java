/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fill Buffer Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFillBufferTask#getContext <em>Context</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFillBufferTask#getDrawTask <em>Draw Task</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFillBufferTask#getVertexBuffer <em>Vertex Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFillBufferTask#getLayoutTask <em>Layout Task</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearFillBufferTask()
 * @model
 * @generated
 */
public interface NuklearFillBufferTask extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(NuklearContext)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearFillBufferTask_Context()
	 * @model required="true"
	 * @generated
	 */
	NuklearContext getContext();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFillBufferTask#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(NuklearContext value);

	/**
	 * Returns the value of the '<em><b>Draw Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Draw Task</em>' reference.
	 * @see #setDrawTask(CompositeTask)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearFillBufferTask_DrawTask()
	 * @model
	 * @generated
	 */
	CompositeTask getDrawTask();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFillBufferTask#getDrawTask <em>Draw Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Draw Task</em>' reference.
	 * @see #getDrawTask()
	 * @generated
	 */
	void setDrawTask(CompositeTask value);

	/**
	 * Returns the value of the '<em><b>Vertex Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex Buffer</em>' reference.
	 * @see #setVertexBuffer(CompositeBuffer)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearFillBufferTask_VertexBuffer()
	 * @model required="true"
	 * @generated
	 */
	CompositeBuffer getVertexBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFillBufferTask#getVertexBuffer <em>Vertex Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex Buffer</em>' reference.
	 * @see #getVertexBuffer()
	 * @generated
	 */
	void setVertexBuffer(CompositeBuffer value);

	/**
	 * Returns the value of the '<em><b>Layout Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout Task</em>' reference.
	 * @see #setLayoutTask(NuklearLayoutTask)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getNuklearFillBufferTask_LayoutTask()
	 * @model required="true"
	 * @generated
	 */
	NuklearLayoutTask getLayoutTask();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFillBufferTask#getLayoutTask <em>Layout Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout Task</em>' reference.
	 * @see #getLayoutTask()
	 * @generated
	 */
	void setLayoutTask(NuklearLayoutTask value);

} // NuklearFillBufferTask
