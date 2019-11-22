/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.sheepy.lily.vulkan.model.process.IPipelineTask;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Render Indexed Draw Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask#getIndexProvider <em>Index Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask#getStructure <em>Structure</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderIndexedDrawTask()
 * @model
 * @generated
 */
public interface RenderIndexedDrawTask extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Index Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Provider</em>' reference.
	 * @see #setIndexProvider(IndexProvider)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderIndexedDrawTask_IndexProvider()
	 * @model required="true"
	 * @generated
	 */
	IndexProvider<?> getIndexProvider();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask#getIndexProvider <em>Index Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Provider</em>' reference.
	 * @see #getIndexProvider()
	 * @generated
	 */
	void setIndexProvider(IndexProvider<?> value);

	/**
	 * Returns the value of the '<em><b>Structure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structure</em>' reference.
	 * @see #setStructure(Structure)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderIndexedDrawTask_Structure()
	 * @model required="true"
	 * @generated
	 */
	Structure getStructure();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask#getStructure <em>Structure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Structure</em>' reference.
	 * @see #getStructure()
	 * @generated
	 */
	void setStructure(Structure value);

} // RenderIndexedDrawTask
